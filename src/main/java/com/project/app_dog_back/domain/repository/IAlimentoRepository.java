package com.project.app_dog_back.domain.repository;

import com.project.app_dog_back.domain.model.entity.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlimentoRepository extends JpaRepository<Alimento, Long> {

    @Query("select count(a) from Alimento a where upper(a.nombre) = upper(:nombre) ")
    Integer getMatchOnNombre(@Param("nombre") String nombre);
}
