package com.isj.gestiondenote.ClientWeb.Model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String title;

    private String description;

    private String image;

    private String author;

    private String edition;

    private String publisher;

    private int numberOfPages;

    private String language;


    private Category category;

    private boolean available;



}