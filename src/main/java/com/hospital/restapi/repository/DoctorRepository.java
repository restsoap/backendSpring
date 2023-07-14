package com.hospital.restapi.repository;

import com.hospital.restapi.domain.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

    //validar si existe el correo
    boolean existsByCorreo(String correo);
}
