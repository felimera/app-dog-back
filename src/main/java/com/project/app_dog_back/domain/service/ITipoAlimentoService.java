package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.TipoAlimentoDto;
import com.project.app_dog_back.domain.model.catalog.TipoAlimento;

import java.util.List;

public interface ITipoAlimentoService {
    List<TipoAlimentoDto> getAll();

    TipoAlimento getById(Long idTipoAlimento);
}
