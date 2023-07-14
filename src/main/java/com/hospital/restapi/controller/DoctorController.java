package com.hospital.restapi.controller;

import com.hospital.restapi.domain.model.Doctor;
import com.hospital.restapi.dto.DoctorDTO;
import com.hospital.restapi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/api/doctores", produces = "application/json")
    public List<Doctor> getDoctores() {
        return doctorService.getAllDoctores();
    }

    @PostMapping(value = "/api/doctores", produces = "application/json")
    public ResponseEntity<String> saveDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.crearDoctor(doctorDTO);
            return ResponseEntity.ok("Doctor creado correctamente");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
