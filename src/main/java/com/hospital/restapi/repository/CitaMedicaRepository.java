package com.hospital.restapi.repository;

import com.hospital.restapi.domain.model.CitaMedica;
import com.hospital.restapi.domain.model.Especialidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaMedicaRepository extends MongoRepository<CitaMedica, Integer> {
    List<CitaMedica> findByEspecialidades(Especialidad especialidad);

}
