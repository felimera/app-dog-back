package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.ClienteDto;
import com.project.app_dog_back.domain.model.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<ClienteDto> getAll();

    ClienteDto getById(Long idCliente);

    Cliente getClienteById(Long idCliente);

    ClienteDto create(ClienteDto dto);
}
