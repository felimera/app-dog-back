package com.project.app_dog_back.domain.model.component;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoNotificacion {
    C("Cumpleaños"), A("Alimento"), B("Baño"), M("Medicamento");

    private String name;

    public static TipoNotificacion of(String name) {
        return Stream.of(TipoNotificacion.values())
                .filter(v -> v.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
