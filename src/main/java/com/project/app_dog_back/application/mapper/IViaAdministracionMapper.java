package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.catalog.ViaAdministracionDto;
import com.project.app_dog_back.domain.model.catalog.ViaAdministracion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IViaAdministracionMapper {
    IViaAdministracionMapper INSTANCE = Mappers.getMapper(IViaAdministracionMapper.class);

    @Mapping(target = "idViaAdministracion", source = "id")
    @Mapping(target = "valido", ignore = true)
    ViaAdministracionDto toDto(ViaAdministracion entity);
}
