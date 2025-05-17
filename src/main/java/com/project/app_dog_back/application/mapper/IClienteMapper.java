package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.ClienteDto;
import com.project.app_dog_back.domain.model.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IClienteMapper {
    IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

    @Mapping(target = "idCliente", source = "id")
    @Mapping(target = "activo", ignore = true)
    ClienteDto toDto(Cliente entity);

    @InheritInverseConfiguration
    Cliente toEntity(ClienteDto dto);
}
