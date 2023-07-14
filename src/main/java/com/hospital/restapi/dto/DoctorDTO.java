package com.hospital.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorDTO {
    private String id;
    private String nombre;
    private String apellido;
    // lista de especialidades
    private List<String> especialidades;
    private String consultorio;
    private String correo;

    public DoctorDTO() {
        // Constructor sin argumentos requerido para la deserialización del JSON
    }

    public DoctorDTO(String nombre, String apellido, List<String> especialidades, String consultorio, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = especialidades;
        this.consultorio = consultorio;
        this.correo = correo;
    }
}

