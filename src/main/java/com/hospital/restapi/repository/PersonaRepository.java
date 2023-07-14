package com.hospital.restapi.repository;

import com.hospital.restapi.domain.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {
    // Para validar si la cedula ya existe
    boolean existsByCedula(String cedula);
}
