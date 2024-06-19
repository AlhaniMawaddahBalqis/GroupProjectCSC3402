package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Medication;

import java.util.List;

public interface MedicationService {

    Medication getMedicationById(String medicationId);

    List<Medication> listAllMedication();

    void addMedication(Medication medication);

    void updateMedication(Medication medication);

    void deleteMedication(String medicationId);

    void save(Medication medication);
}
