package com.project.app_dog_back.domain.model.component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypesStatus {
    SUCCESS("success"), ERROR("error");
    private String name;
}
