package com.csc3402.project.pharmacysm.repository;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Query(value = "SELECT * FROM patient where patient_id = :id", nativeQuery = true)
    Patient findPatientById(@Param("id") String patientId);
}
