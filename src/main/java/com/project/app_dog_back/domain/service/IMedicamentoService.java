package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.MedicamentoDto;
import com.project.app_dog_back.domain.model.entity.Medicamento;

import java.util.List;

public interface IMedicamentoService {
    MedicamentoDto getById(Long id);

    Medicamento getMedicamentoById(Long id);

    List<MedicamentoDto> getAll();

    MedicamentoDto create(MedicamentoDto dto);
}
