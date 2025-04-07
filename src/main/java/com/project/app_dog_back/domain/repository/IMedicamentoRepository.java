package com.project.app_dog_back.domain.repository;

import com.project.app_dog_back.domain.model.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Long> {

    @Query("select count(m) from Medicamento m where upper(m.nombre) = upper(:nombre)")
    Integer getMatchOnName(@Param("nombre") String nombre);
}
