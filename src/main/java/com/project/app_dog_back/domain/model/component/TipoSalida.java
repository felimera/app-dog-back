package com.project.app_dog_back.domain.model.component;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoSalida {
    B("Baño"), P("Paseo"), BP("Baño y paseo"), V("Veterinario");

    private String name;

    public static TipoSalida of(String name) {
        return Stream.of(TipoSalida.values())
                .filter(v -> v.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
