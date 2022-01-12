package com.pro.pro.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProDTO {
    private Integer age;

    private String education_level;

    private PastExperiencesDTO past_experiences;

    private InternetTestDTO internet_test;

    private float writing_score;

    private String referral_code;
}
