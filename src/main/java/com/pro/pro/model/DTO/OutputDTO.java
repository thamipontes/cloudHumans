package com.pro.pro.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OutputDTO {

    private Integer score;
    private String selected_project;
    private List<String> eligible_projects;
    private List<String> ineligible_projects;

}
