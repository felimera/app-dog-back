package com.project.app_dog_back.domain.repository;

import com.project.app_dog_back.domain.model.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerroRepository extends JpaRepository<Perro, Long> {
}
