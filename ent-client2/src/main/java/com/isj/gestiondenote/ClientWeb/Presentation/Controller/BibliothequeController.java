package com.isj.gestiondenote.ClientWeb.Presentation.Controller;

import com.isj.gestiondenote.ClientWeb.Model.dto.AuthorityDto;
import com.isj.gestiondenote.ClientWeb.Model.dto.BookDto;
import com.isj.gestiondenote.ClientWeb.Model.dto.UserDto;
import com.isj.gestiondenote.ClientWeb.Model.dto.UserResponseDto;
import com.isj.gestiondenote.ClientWeb.utils.test.Modal;
import com.isj.gestiondenote.ClientWeb.utils.test.ModalWithHttpHeader;
import com.isj.gestiondenote.ClientWeb.utils.test.URL;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class BibliothequeController {
    @GetMapping("/listeDocument")
    public ModelAndView listeDocument(Model model, HttpSession session) {
        ModalWithHttpHeader.model(model, session);
        Modal.model(model);
        String accessToken = (String) session.getAttribute("accessToken");
        model.addAttribute("accessToken", accessToken);

        RestTemplate restTemplate = new RestTemplate();

        Object[] documents = restTemplate.getForObject(URL.BASE_URL_BIB1+"/all" , Object[].class);
        System.out.println(documents);
        model.addAttribute("documents", documents);

        return new ModelAndView("layout/gestion-bibliotheque/liste-des-documents");

    }

    @GetMapping("/AjouteLivre")
    public ModelAndView AjoutDocument(Model model, HttpSession session) {
        ModalWithHttpHeader.model(model, session);
        Modal.model(model);
        String accessToken = (String) session.getAttribute("accessToken");
        model.addAttribute("accessToken", accessToken);
        System.out.println(model);

        BookDto book = new BookDto();

        model.addAttribute("book", book);

        System.out.println(model);
        return new ModelAndView("layout/gestion-bibliotheque/AjoutLivre");
    }
    @PostMapping("/AjouteLivre")
    public String handleInsertBook(Model model, @ModelAttribute BookDto bookDto , HttpSession session) throws URISyntaxException {
        System.out.println("yes");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        Object book = restTemplate.postForObject(new URI(URL.BASE_URL_BIB1),bookDto, Object.class);
        System.out.println("Utilisateur:"+book);

        return "redirect:dashboard";
    }
    @GetMapping("/supprimerDocument")
    public String supprimerDocument(@RequestParam(name = "id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();
        Object res = restTemplate.getForObject(URL.BASE_URL_BIB + id , Object.class );
        return "redirect:listeDocument";
    }

}
