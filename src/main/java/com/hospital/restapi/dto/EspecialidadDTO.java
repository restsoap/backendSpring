package com.hospital.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class EspecialidadDTO {
    private String id;
    private String nombreEspecialidad;

    public EspecialidadDTO() {
        this.id = new ObjectId().toString();
    }

    public EspecialidadDTO(String nombreEspecialidad) {
        this.id = new ObjectId().toString();
        this.nombreEspecialidad = nombreEspecialidad;
    }
}




