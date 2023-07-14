package com.hospital.restapi.controller;

import com.hospital.restapi.domain.model.CitaMedica;
import com.hospital.restapi.domain.model.Especialidad;
import com.hospital.restapi.dto.CitaMedicaDTO;
import com.hospital.restapi.dto.EspecialidadDTO;
import com.hospital.restapi.service.CitaMedicaService;
import com.hospital.restapi.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/citas")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/especialidad/{especialidadId}")
    public List<CitaMedica> getCitasPorEspecialidad(@PathVariable String especialidadId) {
        Especialidad especialidad = obtenerEspecialidadPorId(especialidadId);
        return citaMedicaService.getCitasPorEspecialidad(especialidad);
    }

    @PostMapping(value = "/api/citasMedicas", produces = "application/json")
    public ResponseEntity<String> saveCitaMedica(@RequestBody CitaMedicaDTO citaMedicaDTO) {
        try {
            citaMedicaService.crearCitaMedica(citaMedicaDTO);
            return ResponseEntity.ok("Cita Medica creada correctamente");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: " + ex.getMessage());
        }
    }

    @GetMapping(value = "/api/citasMedicas", produces = "application/json")
    public List<CitaMedica> getCitasMedicas() {
        return citaMedicaService.getAllCitasMedicas();
    }

    private Especialidad obtenerEspecialidadPorId(String especialidadId) {
        return especialidadService.obtenerEspecialidadPorId(especialidadId);
    }
}
