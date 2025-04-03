package com.project.app_dog_back.domain.model.component;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Tamano {

    P("Pequeño"), M("Mediano"), G("Grande");

    private String name;

    public static Tamano of(String name) {
        return Stream.of(Tamano.values())
                .filter(p -> p.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
