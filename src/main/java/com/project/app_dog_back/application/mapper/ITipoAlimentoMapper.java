package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.catalog.TipoAlimentoDto;
import com.project.app_dog_back.domain.model.catalog.TipoAlimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ITipoAlimentoMapper {
    ITipoAlimentoMapper INSTANCE = Mappers.getMapper(ITipoAlimentoMapper.class);

    @Mapping(target = "idTipoAlimento", source = "id")
    @Mapping(target = "valido", ignore = true)
    TipoAlimentoDto toDto(TipoAlimento entity);
}
