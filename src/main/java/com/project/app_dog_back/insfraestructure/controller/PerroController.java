package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.PerroDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IPerroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Perro", description = "Dog-related operations.")
@RestController
@RequestMapping(path = "/api/v1/perro")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class PerroController {

    private IPerroService iPerroService;

    @Autowired
    public PerroController(IPerroService iPerroService) {
        this.iPerroService = iPerroService;
    }

    @Operation(summary = "Create a dog registration.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody PerroDto perroDto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iPerroService.create(perroDto));

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id")Long id ) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iPerroService.getById(id));

        return ResponseEntity.ok(response);
    }
}
