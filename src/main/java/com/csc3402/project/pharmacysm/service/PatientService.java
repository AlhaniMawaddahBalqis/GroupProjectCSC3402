package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Patient;

import java.util.List;

public interface PatientService {

    Patient getPatientById(String patientId);

    Patient findPatientById(String patientId);


    List<Patient> listAllPatients();

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(String patientId);
}