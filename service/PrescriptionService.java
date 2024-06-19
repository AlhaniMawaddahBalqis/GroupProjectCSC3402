package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.model.Physician;
import com.csc3402.lab.pharmacy.model.Prescription;

import java.time.LocalDate;
import java.util.List;

public interface PrescriptionService {
    List<Prescription> getAllPrescriptions();
    Prescription savePrescription(Prescription prescription);
    Prescription findPrescriptionById(String id);
    Prescription updatePrescription(String id, Prescription prescription); // Update method
    void deletePrescription(String id);

    List<Prescription> getPrescriptionsByPatient(Patient patient);
    List<Prescription> getPrescriptionsByPhysician(Physician physician);
    List<Prescription> getPrescriptionsByPrescDate(LocalDate prescDate);

    Prescription createPrescription(Prescription prescription); // Create method
    Prescription getPrescriptionById(String id);
}
