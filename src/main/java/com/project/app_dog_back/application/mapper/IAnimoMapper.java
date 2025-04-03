package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.AnimoDto;
import com.project.app_dog_back.domain.model.catalog.Animo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAnimoMapper {
    IAnimoMapper INSTANCE = Mappers.getMapper(IAnimoMapper.class);

    @Mapping(target = "idAnimo", source = "id")
    @Mapping(target = "valido", ignore = true)
    AnimoDto toDto(Animo entity);
}
