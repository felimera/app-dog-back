package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.catalog.AnimoDto;
import com.project.app_dog_back.domain.model.catalog.Animo;

import java.util.List;

public interface IAnimoService {
    List<AnimoDto> getAll();

    Animo getById(Long idAnimo);
}
