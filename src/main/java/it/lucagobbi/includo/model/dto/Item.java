package it.lucagobbi.includo.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Item {

    private Date dateOfStart;
    private Date dateOfEnd;
    private String location;
    private String description;

}
