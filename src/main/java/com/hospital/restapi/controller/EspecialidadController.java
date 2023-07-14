package com.hospital.restapi.controller;

import com.hospital.restapi.domain.model.Especialidad;
import com.hospital.restapi.dto.EspecialidadDTO;
import com.hospital.restapi.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping(value = "/api/especialidades", produces = "application/json")
    public List<Especialidad> getEspecialidades() {
        return especialidadService.getAllEspecialidades();
    }

    @PostMapping(value = "/api/especialidades", produces = "application/json")
    public ResponseEntity<Void> saveEspecialidad(@RequestBody EspecialidadDTO especialidadDTO) {
        especialidadService.crearEspecialidad(especialidadDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}