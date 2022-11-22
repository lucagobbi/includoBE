package it.lucagobbi.includo.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExperienceItem extends Item {

    private List<Skill> appliedSkills;

}
