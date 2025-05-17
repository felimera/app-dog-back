package com.project.app_dog_back.application.dto;

import com.project.app_dog_back.insfraestructure.utils.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MascotaDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idMascota;
    @Schema(description = "Name of the pet.", example = "Max")
    @NotEmpty(message = "The pet name cannot be empty.")
    @NotNull(message = "The pet name cannot be null.")
    @Size(max = 100, message = "The pet's name only has a maximum of 100 characters.")
    private String nombre;
    @Schema(description = "Age of the pet.", example = "4")
    private Integer edad;
    @Schema(description = "Date of birth of the pet.", example = "2020-01-01")
    @Pattern(regexp = Constant.REGEXP_DATE, message = "Incorrect date format. Ex: yyyy-MM-dd.")
    private String fechaNacimiento;
    @Schema(description = "Foreign key identifier. (Raza)", example = "1")
    private Long idRaza;
    @Schema(description = "Foreign key identifier. (Color de pelo)", example = "1")
    private Long idColorPelo;
    @Schema(description = "Foreign key identifier. (Cliente)", example = "1")
    private Long idCliente;
}
