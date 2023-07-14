package com.hospital.restapi.repository;

import com.hospital.restapi.domain.model.Especialidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {

}
