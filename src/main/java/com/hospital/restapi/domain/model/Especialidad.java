package com.hospital.restapi.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "especialidades")
public class Especialidad {

    @Id
    private String id;
    private String nombreEspecialidad;

    public Especialidad() {
        this.id = new ObjectId().toString();
    }

    public Especialidad(String nombreEspecialidad) {
        this.id = new ObjectId().toString();
        this.nombreEspecialidad = nombreEspecialidad;
    }
}



