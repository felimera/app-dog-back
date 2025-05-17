package com.project.app_dog_back.application.mapper;

import com.project.app_dog_back.application.dto.RevisionDto;
import com.project.app_dog_back.domain.model.entity.Revision;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IRevisionMapper {
    IRevisionMapper INSTANCE = Mappers.getMapper(IRevisionMapper.class);

    @Mapping(target = "idRevision", source = "id")
    RevisionDto toDto(Revision entity);

    @InheritInverseConfiguration
    Revision toEntity(RevisionDto dto);
}
