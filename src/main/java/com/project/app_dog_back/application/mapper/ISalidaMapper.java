package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.SalidaDto;
import com.project.app_dog_back.domain.model.component.TipoSalida;
import com.project.app_dog_back.domain.model.entity.Salida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ISalidaMapper {
    ISalidaMapper INSTANCE = Mappers.getMapper(ISalidaMapper.class);

    @Mapping(target = "idSalida", source = "id")
    @Mapping(target = "isSalidaRealizada", source = "salidaRealizada")
    @Mapping(target = "tipoSalida", expression = "java(getTipoSalida(entity.getTipoSalida()))")
    SalidaDto toDto(Salida entity);

    @InheritInverseConfiguration
    Salida toEntity(SalidaDto dto);

    default String getTipoSalida(TipoSalida value) {
        return TipoSalida.of(value.name()).getName();
    }
}
