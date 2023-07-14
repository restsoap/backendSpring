package com.hospital.restapi.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "Persona")
public class Persona implements Serializable {

    @Id
    private ObjectId id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Integer edad;
    private String telefono;

    public Persona() {
        this.id = new ObjectId();
    }

    public Persona(String nombre, String apellido, String cedula, Integer edad, String telefono) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
    }
}

