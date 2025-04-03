package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.MovilidadDto;
import com.project.app_dog_back.domain.model.catalog.Movilidad;

import java.util.List;

public interface IMovilidadService {
    List<MovilidadDto> getAll();

    Movilidad getById(Long idMovlidad);
}
