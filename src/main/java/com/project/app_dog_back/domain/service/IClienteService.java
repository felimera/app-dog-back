package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.ClienteDto;

import java.util.List;

public interface IClienteService {
    List<ClienteDto> getAll();

    ClienteDto getById(Long idCliente);

    ClienteDto create(ClienteDto dto);
}
