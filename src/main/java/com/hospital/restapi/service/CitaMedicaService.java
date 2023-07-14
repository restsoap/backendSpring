package com.hospital.restapi.service;

import com.hospital.restapi.domain.model.CitaMedica;
import com.hospital.restapi.domain.model.Doctor;
import com.hospital.restapi.domain.model.Especialidad;
import com.hospital.restapi.domain.model.Persona;
import com.hospital.restapi.dto.CitaMedicaDTO;
import com.hospital.restapi.repository.CitaMedicaRepository;
import com.hospital.restapi.repository.DoctorRepository;
import com.hospital.restapi.repository.EspecialidadRepository;
import com.hospital.restapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<CitaMedica> getCitasPorEspecialidad(Especialidad especialidad) {
        return citaMedicaRepository.findByEspecialidades(especialidad);
    }

    public List<CitaMedica> getAllCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    public void crearCitaMedica(CitaMedicaDTO citaMedicaDTO) {
        List<String> especialidadIds = citaMedicaDTO.getEspecialidades();
        List<String> pacienteIds = citaMedicaDTO.getPacientes();
        List<String> doctorIds = citaMedicaDTO.getDoctores();

        List<Especialidad> especialidades = especialidadIds.stream()
                .map(especialidadId -> especialidadRepository.findById(especialidadId)
                        .orElseThrow(() -> new NoSuchElementException("No se encontró la especialidad con el ID: " + especialidadId)))
                .collect(Collectors.toList());

        List<Persona> pacientes = pacienteIds.stream()
                .map(pacienteId -> personaRepository.findById(pacienteId)
                        .orElseThrow(() -> new NoSuchElementException("No se encontró la persona con el ID: " + pacienteId)))
                .collect(Collectors.toList());

        List<Doctor> doctores = doctorIds.stream()
                .map(doctorId -> doctorRepository.findById(doctorId)
                        .orElseThrow(() -> new NoSuchElementException("No se encontró el doctor con el ID: " + doctorId)))
                .collect(Collectors.toList());

        CitaMedica citaMedica = new CitaMedica(especialidades, pacientes, doctores);

        citaMedicaRepository.save(citaMedica);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

