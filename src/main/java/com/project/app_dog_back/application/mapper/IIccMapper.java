package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.IccDto;
import com.project.app_dog_back.domain.model.catalog.Icc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IIccMapper {
    IIccMapper INSTANCE = Mappers.getMapper(IIccMapper.class);

    @Mapping(source = "id", target = "idIcc")
    @Mapping(target = "valido", ignore = true)
    IccDto toDto(Icc entity);
}
