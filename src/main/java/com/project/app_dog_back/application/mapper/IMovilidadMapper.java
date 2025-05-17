package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.catalog.MovilidadDto;
import com.project.app_dog_back.domain.model.catalog.Movilidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMovilidadMapper {
    IMovilidadMapper INSTANCE = Mappers.getMapper(IMovilidadMapper.class);

    @Mapping(target = "idMovilidad", source = "id")
    @Mapping(target = "valido", ignore = true)
    MovilidadDto toDto(Movilidad entity);
}
