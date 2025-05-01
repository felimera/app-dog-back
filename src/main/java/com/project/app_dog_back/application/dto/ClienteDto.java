package com.project.app_dog_back.application.dto;

import com.project.app_dog_back.insfraestructure.utils.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Integer idCliente;
    @Schema(description = "Name of the customer.", example = "Nombre de prueba")
    @NotEmpty(message = "The customer name cannot be empty.")
    @NotNull(message = "The customer name cannot be null.")
    @Size(max = 100, message = "The customer's name only has a maximum of 100 characters.")
    @Pattern(regexp = Constant.REGEXP_ONLYLETTERS, message = "It is not a valid name.")
    private String nombre;
    @Schema(description = "Last name of the customer.", example = "Apellido de prueba")
    @Size(max = 100, message = "The customer's name only has a maximum of 100 characters.")
    @Pattern(regexp = Constant.REGEXP_ONLYLETTERS, message = "It is not a valid name.")
    private String apellido;
    @Schema(description = "Customer email.", example = "test@test.com")
    @NotEmpty(message = "The customer's email cannot be empty.")
    @Email(message = "The email is not formatted correctly.")
    @Size(max = 100, message = "The customer's email only has a maximum of 100 characters.")
    private String email;
    @Schema(description = "Customer's phone number.", example = "321475241")
    @Size(min = 7, message = "The phone number must have a minimum of seven (7) digits.")
    @Size(max = 10, message = "The phone number must have a maximum of ten (10) digits.")
    @Pattern(regexp = Constant.REGEXP_NUMBER, message = "The phone number should only contain numbers.")
    private String telefono;
    @Schema(description = "Customer address.", example = "Carrera 01 # 12-23")
    private String direccion;
    @Schema(description = "Client's date of birth.", example = "1990-01-01")
    @Pattern(regexp = Constant.REGEXP_DATE, message = "Incorrect date format. Ex: yyyy-MM-dd.")
    private String fechaNacimiento;
    @Schema(description = "Registration active or disabled.", example = "true")
    private Boolean activo;
}
