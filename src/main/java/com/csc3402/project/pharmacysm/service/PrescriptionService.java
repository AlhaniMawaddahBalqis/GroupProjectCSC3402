package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.*;

import java.time.LocalDate;
import java.util.List;

public interface PrescriptionService {
    List<Prescription> getAllPrescriptions();
    Prescription savePrescription(Prescription prescription);

    Prescription findPrescriptionById(String prescId);

    Prescription updatePrescription(Prescription prescription); // Updated method
    void deletePrescription(String prescId);

    List<Prescription> getPrescriptionsByPatient(Patient patient);
    List<Prescription> getPrescriptionsByPhysician(Physician physician);
    List<Prescription> getPrescriptionsByPrescDate(LocalDate prescDate);
    List<Prescription> getPrescriptionsByMedication(Medication medication);
    List<Prescription> getPrescriptionsByPharmacist(Pharmacist pharmacist);

    Prescription createPrescription(Prescription prescription); // Create method
    Prescription getPrescriptionById(String prescId);


    List<Prescription> listAllPrescriptions();

}
