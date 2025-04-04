package com.project.app_dog_back.domain.repository;

import com.project.app_dog_back.domain.model.catalog.UnidadMasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidadMasaRepository extends JpaRepository<UnidadMasa, Long> {
}
