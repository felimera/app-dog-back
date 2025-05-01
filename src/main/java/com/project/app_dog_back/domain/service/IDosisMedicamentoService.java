package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.domain.model.entity.DosisMedicamento;

import java.util.List;

public interface IDosisMedicamentoService {
    DosisMedicamentoDto getById(Long id);

    List<DosisMedicamentoDto> getAll();

    DosisMedicamentoDto create(DosisMedicamentoDto dto);

    DosisMedicamento getDosisMedicamento(Long idDosisMedicamento);
}
