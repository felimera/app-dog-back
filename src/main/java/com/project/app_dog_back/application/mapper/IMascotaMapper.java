package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.MascotaDto;
import com.project.app_dog_back.domain.model.entity.Mascota;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMascotaMapper {

    IMascotaMapper INSTANCE = Mappers.getMapper(IMascotaMapper.class);

    @Mapping(target = "idMascota", source = "id")
    MascotaDto toDto(Mascota entity);

    @InheritInverseConfiguration
    Mascota toEntity(MascotaDto dto);
}
