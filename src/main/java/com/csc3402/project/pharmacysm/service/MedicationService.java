package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Medication;

import java.util.List;

public interface MedicationService {

    Medication getMedicationById(String medId);

    List<Medication> listAllMedication();

    Medication findMedicationById(String medId);

    void addMedication(Medication medication);

    void updateMedication(Medication medication);

    void deleteMedication(String medId);

    void save(Medication medication);

}