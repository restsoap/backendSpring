package com.hospital.restapi.service;

import com.hospital.restapi.domain.model.Especialidad;
import com.hospital.restapi.dto.EspecialidadDTO;
import com.hospital.restapi.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    public void crearEspecialidad(EspecialidadDTO especialidadDTO) {
        Especialidad especialidad = new Especialidad(especialidadDTO.getNombreEspecialidad());
        especialidadRepository.save(especialidad);
    }

    public Especialidad obtenerEspecialidadPorId(String especialidadId) {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(String.valueOf(especialidadId));

        if (especialidadOptional.isEmpty()) {
            throw new NoSuchElementException("No se encontró la especialidad con el ID: " + especialidadId);
        }

        return especialidadOptional.get();
    }
}
