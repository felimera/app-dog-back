package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.catalog.RazaDto;
import com.project.app_dog_back.domain.model.catalog.Raza;
import com.project.app_dog_back.domain.model.component.Tamano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IRazaMapper {
    IRazaMapper INSTANCE = Mappers.getMapper(IRazaMapper.class);

    @Mapping(target = "idRaza", source = "id")
    @Mapping(target = "valido", ignore = true)
    @Mapping(target = "tamano", expression = "java(getTamano(entity.getTamano()))")
    RazaDto toDto(Raza entity);

    default String getTamano(Tamano value) {
        return Tamano.of(value.name()).getName();
    }
}
