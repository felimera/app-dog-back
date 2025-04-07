package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.MedicamentoDto;
import com.project.app_dog_back.domain.model.entity.Medicamento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMedicamentoMapper {
    IMedicamentoMapper INSTANCE = Mappers.getMapper(IMedicamentoMapper.class);

    @Mapping(target = "idMedicamento", source = "id")
    MedicamentoDto toDto(Medicamento entity);

    @InheritInverseConfiguration
    Medicamento toEntity(MedicamentoDto dto);
}
