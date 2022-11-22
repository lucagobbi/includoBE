package it.lucagobbi.includo.model.dto;

import lombok.Data;

@Data
public class EducationItem extends Item{

    private String field;
    private String title;
    private String graduation;

}
