package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.domain.model.entity.DosisMedicamento;
import com.project.app_dog_back.insfraestructure.utils.DateUtil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface IDosisMedicamentoMapper {
    IDosisMedicamentoMapper INSTANCE = Mappers.getMapper(IDosisMedicamentoMapper.class);

    @Mapping(target = "idDosisMedicamento", source = "id")
    @Mapping(target = "fecha", expression = "java(getStringUTC(entity.getFecha()))")
    DosisMedicamentoDto toDto(DosisMedicamento entity);

    @InheritInverseConfiguration
    @Mapping(target = "fecha", expression = "java(getDateUTC(dto.getFecha()))")
    DosisMedicamento toEntity(DosisMedicamentoDto dto);

    default LocalDateTime getDateUTC(String fecha) {
        return DateUtil.getLocalDateTimeOfString(fecha);
    }

    default String getStringUTC(LocalDateTime fecha) {
        return fecha.toString();
    }
}
