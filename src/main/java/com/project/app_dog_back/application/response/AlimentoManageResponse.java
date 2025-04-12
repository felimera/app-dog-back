package com.project.app_dog_back.application.response;

import com.project.app_dog_back.application.dto.AlimentoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AlimentoManageResponse {
    @Schema(description = "Indicates the status of the response.", examples = {"400", "404", "500"})
    public String status;
    @Schema(description = "Request response message.", example = "Record created successfully.")
    public String message;
    @Schema(description = "Object of response of the request.", exampleClasses = AlimentoDto.class)
    public Object data;
}
