package com.hospital.restapi.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Document(collection = "CitasMedicas")
public class CitaMedica implements Serializable {

    @Id
    private String id;

    @DBRef
    private List<Especialidad> especialidades;

    @DBRef
    private List<Persona> pacientes;

    @DBRef
    private List<Doctor> doctores;

    public CitaMedica(List<Especialidad> especialidades, List<Persona> pacientes, List<Doctor> doctores) {
        this.id = new ObjectId().toString();
        this.especialidades = especialidades;
        this.pacientes = pacientes;
        this.doctores = doctores;
    }
}
