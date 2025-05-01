package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.NotificacionDto;
import com.project.app_dog_back.domain.model.component.TipoNotificacion;
import com.project.app_dog_back.domain.model.entity.Notificacion;
import com.project.app_dog_back.insfraestructure.utils.DateUtil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface INotificacionMapper {
    INotificacionMapper INSTANCE = Mappers.getMapper(INotificacionMapper.class);

    @Mapping(target = "idNotificacion", source = "id")
    @Mapping(target = "isNotificacionValidacion", source = "notificacionValidacion")
    @Mapping(target = "tipoNotificacion", expression = "java(getTipoNotificacion(entity.getTipoNotificacion()))")
    @Mapping(target = "fecha", expression = "java(getStringUTC(entity.getFecha()))")
    NotificacionDto toDto(Notificacion entity);

    @InheritInverseConfiguration
    @Mapping(target = "fecha", expression = "java(getDateUTC(dto.getFecha()))")
    Notificacion toEntity(NotificacionDto dto);

    default String getTipoNotificacion(TipoNotificacion value) {
        return TipoNotificacion.of(value.name()).getName();
    }

    default LocalDateTime getDateUTC(String fecha) {
        return DateUtil.getLocalDateTimeOfString(fecha);
    }

    default String getStringUTC(LocalDateTime fecha) {
        return fecha.toString();
    }
}
