package com.hospital.restapi.controller;

import com.hospital.restapi.domain.model.Persona;
import com.hospital.restapi.dto.PersonaDTO;
import com.hospital.restapi.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "/api/personas", produces = "application/json")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> personas = personaService.getAllPersonas();
        if (personas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personas);
        } else {
            return ResponseEntity.ok(personas);
        }
    }

    @PostMapping(value = "/api/personas", produces = "application/json")
    public ResponseEntity<String> savePersona(@RequestBody PersonaDTO personaDTO) {
        try {
            personaService.crearPersona(personaDTO);
            return ResponseEntity.ok("Persona agregada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: " + e.getMessage());
        }
    }
}


