package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.domain.model.entity.DosisMedicamento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDosisMedicamentoMapper {
    IDosisMedicamentoMapper INSTANCE = Mappers.getMapper(IDosisMedicamentoMapper.class);

    @Mapping(target = "idDosisMedicamento", source = "id")
    DosisMedicamentoDto toDto(DosisMedicamento entity);

    @InheritInverseConfiguration
    DosisMedicamento toEntity(DosisMedicamentoDto dto);
}
