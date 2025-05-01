package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.SuministroAlimentoDto;
import com.project.app_dog_back.domain.model.entity.SuministroAlimento;
import com.project.app_dog_back.insfraestructure.utils.DateUtil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface ISuministroAlimentoMapper {
    ISuministroAlimentoMapper INSTANCE = Mappers.getMapper(ISuministroAlimentoMapper.class);

    @Mapping(target = "idSuministro", source = "id")
    @Mapping(target = "isSuministroDado", source = "suministroDado")
    @Mapping(target = "fecha", expression = "java(getStringUTC(entity.getFecha()))")
    SuministroAlimentoDto toDto(SuministroAlimento entity);

    @InheritInverseConfiguration
    @Mapping(target = "fecha", expression = "java(getDateUTC(dto.getFecha()))")
    SuministroAlimento toEntity(SuministroAlimentoDto dto);

    default LocalDateTime getDateUTC(String fecha) {
        return DateUtil.getLocalDateTimeOfString(fecha);
    }

    default String getStringUTC(LocalDateTime fecha) {
        return fecha.toString();
    }
}
