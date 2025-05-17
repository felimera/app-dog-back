package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.catalog.ViaAdministracionDto;
import com.project.app_dog_back.domain.model.catalog.ViaAdministracion;

import java.util.List;

public interface IViaAdministracionService {
    List<ViaAdministracionDto> getAll();

    ViaAdministracion getById(Long idViaAdministracion);
}
