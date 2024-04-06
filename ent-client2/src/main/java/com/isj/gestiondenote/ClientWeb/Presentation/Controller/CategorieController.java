package com.isj.gestiondenote.ClientWeb.Presentation.Controller;

import com.isj.gestiondenote.ClientWeb.utils.test.Modal;
import com.isj.gestiondenote.ClientWeb.utils.test.ModalWithHttpHeader;
import com.isj.gestiondenote.ClientWeb.utils.test.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
public class CategorieController {
    @GetMapping("/listeCategorie")
    public ModelAndView listeCategorie(Model model, HttpSession session) {
        ModalWithHttpHeader.model(model, session);
        Modal.model(model);
        String accessToken = (String) session.getAttribute("accessToken");
        model.addAttribute("accessToken", accessToken);
        System.out.println(model);
        System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        RestTemplate restTemplate = new RestTemplate();

        Object[] categories = restTemplate.getForObject(URL.BASE_URL_BIB1+"api/book/category" , Object[].class);
        model.addAttribute("categories", categories);

        System.out.println(model);
        return new ModelAndView("pages/gestion-bibliotheque/liste-des-categories");

    }
}
