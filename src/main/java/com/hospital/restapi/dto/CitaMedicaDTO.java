package com.hospital.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class CitaMedicaDTO {

    private List<String> especialidades;
    private List<String> pacientes;
    private List<String> doctores;

    public CitaMedicaDTO() {
        // Constructor sin argumentos requerido para la deserialización JSON
    }

    public CitaMedicaDTO(List<String> especialidades, List<String> pacientes, List<String> doctores) {
        this.especialidades = especialidades;
        this.pacientes = pacientes;
        this.doctores = doctores;
    }
}


