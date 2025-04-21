package com.project.app_dog_back.insfraestructure.utils;

public class Constant {
    private Constant() {
        throw new IllegalStateException(Constant.class.toString());
    }

    public static final String REGEXP_DATE = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    public static final String REGEXP_NUMBER = "\\d+";
    public static final String REGEXP_ONLYLETTERS = "^[ a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";
}
