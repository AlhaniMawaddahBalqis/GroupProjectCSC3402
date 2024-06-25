package com.csc3402.project.pharmacysm.repository;

import com.csc3402.project.pharmacysm.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, String> {

    List<Prescription> findByPatient(Patient patient);

    List<Prescription> findByPhysician(Physician physician);

    List<Prescription> findByPrescDate(LocalDate prescDate);

    List<Prescription> findByMedication(Medication medication);

    List<Prescription> findByPharmacist(Pharmacist pharmacist);

    @Query("SELECT p FROM Prescription p WHERE p.prescId = :id")
    Prescription findPrescriptionById(@Param("id") String prescId);
}