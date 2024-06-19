package com.csc3402.lab.pharmacy.repository;

import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.model.Physician;
import com.csc3402.lab.pharmacy.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, String> {

    List<Prescription> findByPatient(Patient patient);

    List<Prescription> findByPhysician(Physician physician);

    List<Prescription> findByPrescDate(LocalDate prescDate);
}



