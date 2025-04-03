package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.ColorPeloDto;
import com.project.app_dog_back.domain.model.catalog.ColorPelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IColorPeloMapper {
    IColorPeloMapper INSTANCE = Mappers.getMapper(IColorPeloMapper.class);

    @Mapping(target = "idColorPelo", source = "id")
    @Mapping(target = "valido", ignore = true)
    ColorPeloDto toDto(ColorPelo entity);
}
