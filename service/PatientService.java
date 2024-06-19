package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Patient;

import java.util.List;

public interface PatientService {

    Patient getPatientById(String patientId);

    List<Patient> listAllPatients();

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(String patientId);
}
