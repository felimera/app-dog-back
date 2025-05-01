package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.catalog.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mas_id")
    private Integer id;
    @Column(name = "mas_nombre", nullable = false, columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "mas_edad")
    private Integer edad;
    @Column(name = "mas_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mas_raza_id")
    private Raza raza;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mas_color_pelo_id")
    private ColorPelo colorPelo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mas_cliente_id")
    private Cliente cliente;
}
