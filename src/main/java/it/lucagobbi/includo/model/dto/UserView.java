package it.lucagobbi.includo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserView {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;

}
