package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.AlimentoDto;
import com.project.app_dog_back.domain.model.entity.Alimento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAlimentoMapper {
    IAlimentoMapper INSTANCE = Mappers.getMapper(IAlimentoMapper.class);

    @Mapping(target = "idAlimento", source = "id")
    AlimentoDto toDto(Alimento entity);

    @InheritInverseConfiguration
    Alimento toEntity(AlimentoDto dto);
}
