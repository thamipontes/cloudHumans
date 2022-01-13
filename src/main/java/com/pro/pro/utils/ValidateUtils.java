package com.pro.pro.utils;

import com.pro.pro.enuns.EducationLevel;
import com.pro.pro.exception.ApiRequestExcept;
import com.pro.pro.model.DTO.ProDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidateUtils {

    private ValidateUtils() {}

    public static void validateProDTO(ProDTO proDTO) {
        validateAge(proDTO.getAge());
        validateEducationLevel(proDTO);
        validatePastExperiences(proDTO);
        validadeWritingScore(proDTO);
        validateInternetTest(proDTO);
        validadeWritingScore(proDTO);
    }

    public static void validateAge(Integer age) {
        if (Objects.isNull(age)) throw new ApiRequestExcept("Field Age is wrong or null");
        if (age < 0) throw new ApiRequestExcept("Age can not be negative");
    }

    public static void validateEducationLevel(ProDTO proDTO) {
        if (Objects.isNull(proDTO.getEducation_level())) throw new ApiRequestExcept(
            "Field Education Level is wrong or not exist"
        );

        List<String> educationLevel = new ArrayList<>();

        educationLevel.add(EducationLevel.NO_EDUCATION.getValor());
        educationLevel.add(EducationLevel.HIGH_SCHOOL.getValor());
        educationLevel.add(EducationLevel.BACHELORS_DEGREE_OR_HIGH.getValor());

        if (!educationLevel.contains(proDTO.getEducation_level())) {
            throw new ApiRequestExcept("Value not accept");
        }
    }

    public static void validatePastExperiences(ProDTO proDTO) {
        if (Objects.isNull(proDTO.getPast_experiences())) {
            throw new ApiRequestExcept("Past Experience is wrong or not exist");
        }
    }

    public static void validateInternetTest(ProDTO proDTO) {
        if (Objects.isNull(proDTO.getInternet_test())) throw new ApiRequestExcept(
            "Internet Test is wrong or not exist"
        );
    }

    public static void validadeWritingScore(ProDTO proDTO) {
        if (Objects.isNull(proDTO.getWriting_score())) throw new ApiRequestExcept(
            ("Writing Score is wrong or not exist")
        );
        if (proDTO.getWriting_score() < 0 || proDTO.getWriting_score() > 1) {
            throw new ApiRequestExcept("must be between 0 and 1");
        }
    }
}
