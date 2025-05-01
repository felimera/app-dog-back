package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.catalog.UnidadMasaDto;
import com.project.app_dog_back.domain.model.catalog.UnidadMasa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUnidadMasaMapper {
    IUnidadMasaMapper INSTANCE = Mappers.getMapper(IUnidadMasaMapper.class);

    @Mapping(target = "idUnidadMasa", source = "id")
    @Mapping(target = "valido", ignore = true)
    UnidadMasaDto toDto(UnidadMasa entity);
}
