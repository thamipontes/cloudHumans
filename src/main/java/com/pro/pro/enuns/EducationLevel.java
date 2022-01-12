package com.pro.pro.enuns;

public enum EducationLevel {
    NO_EDUCATION("no_education"),
    HIGH_SCHOOL("high_school"),
    BACHELORS_DEGREE_OR_HIGH("bachelors_degree_or_high");

    private String valor;

    EducationLevel(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
