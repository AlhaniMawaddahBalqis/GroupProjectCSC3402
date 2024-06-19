package com.csc3402.lab.pharmacy.repository;


import com.csc3402.lab.pharmacy.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findByName(String name);

    Patient findByIc(String ic);

    List<Patient> findByGender(String gender);

    List<Patient> findByDob(LocalDate dob);

    // Custom query example using JPQL
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:keyword%")
    List<Patient> searchByNameContaining(String keyword);
}


