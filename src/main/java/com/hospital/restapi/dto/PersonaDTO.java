package com.hospital.restapi.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class PersonaDTO {
    private ObjectId id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Integer edad;
    private String telefono;

    public PersonaDTO() {
        this.id = new ObjectId();
    }

    public PersonaDTO(String nombre, String apellido, String cedula, Integer edad, String telefono) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
    }

    // Getters y setters adicionales si es necesario
}

