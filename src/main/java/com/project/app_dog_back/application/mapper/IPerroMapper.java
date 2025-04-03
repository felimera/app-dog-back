package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.PerroDto;
import com.project.app_dog_back.domain.model.entity.Perro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPerroMapper {

    IPerroMapper INSTANCE = Mappers.getMapper(IPerroMapper.class);

    @Mapping(target = "idPerro", source = "id")
    PerroDto toDto(Perro entity);

    @InheritInverseConfiguration
    Perro toEntity(PerroDto dto);
}
