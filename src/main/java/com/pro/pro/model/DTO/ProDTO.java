package com.pro.pro.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProDTO {

    @NonNull
    private Integer age;

    @NonNull
    private String education_level;

    @NonNull
    private PastExperiencesDTO past_experiences;

    @NonNull
    private InternetTestDTO internet_test;

    @NonNull
    private float writing_score;

    private String referral_code;
}
