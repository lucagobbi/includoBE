package it.lucagobbi.includo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {

    private UserView user;
    private String introduction;
    private List<EducationItem> educationItems;
    private List<ExperienceItem> experienceItems;
    private List<Skill> skills;
    private List<Contact> contacts;

}
