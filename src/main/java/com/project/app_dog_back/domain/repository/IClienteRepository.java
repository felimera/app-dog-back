package com.project.app_dog_back.domain.repository;

import com.project.app_dog_back.domain.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("select count(c) from Cliente c where c.email = :email")
    Integer getMatchOnEmail(@Param("email") String email);
}
