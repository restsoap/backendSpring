package com.hospital.restapi.service;

import com.hospital.restapi.domain.model.Doctor;
import com.hospital.restapi.domain.model.Especialidad;
import com.hospital.restapi.dto.DoctorDTO;
import com.hospital.restapi.repository.DoctorRepository;
import com.hospital.restapi.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository) {
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
    }

    public List<Doctor> getAllDoctores() {
        return doctorRepository.findAll();
    }

    public void crearDoctor(DoctorDTO doctorDTO) {
        String correo = doctorDTO.getCorreo();

        if (doctorRepository.existsByCorreo(correo)) {
            throw new RuntimeException("El correo ya se encuentra registrado: " + correo);
        }

        List<Especialidad> especialidades = doctorDTO.getEspecialidades().stream()
                .map(especialidadId -> especialidadRepository.findById(especialidadId)
                        .orElseThrow(() -> new NoSuchElementException("No se encontró la especialidad con el ID: " + especialidadId)))
                .collect(Collectors.toList());

        Doctor doctor = new Doctor(
                doctorDTO.getNombre(),
                doctorDTO.getApellido(),
                especialidades,
                doctorDTO.getConsultorio(),
                doctorDTO.getCorreo()
        );

        doctorRepository.save(doctor);
    }


    public Doctor obtenerDoctorPorId(String doctorId) {
        return doctorRepository.findById(String.valueOf(doctorId))
                .orElseThrow(() -> new NoSuchElementException("No se encontró el doctor con el ID: " + doctorId));
    }
}


