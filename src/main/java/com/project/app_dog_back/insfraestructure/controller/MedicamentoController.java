package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.MedicamentoDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IMedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Medicamento", description = "Operations related to medicines.")
@RestController
@RequestMapping(path = "/api/v1/medicamento")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {

    private IMedicamentoService iMedicamentoService;

    @Autowired
    public MedicamentoController(IMedicamentoService iMedicamentoService) {
        this.iMedicamentoService = iMedicamentoService;
    }

    @Operation(summary = "Create a medicine registration.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody MedicamentoDto dto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iMedicamentoService.create(dto));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iMedicamentoService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtain all medication records.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iMedicamentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
