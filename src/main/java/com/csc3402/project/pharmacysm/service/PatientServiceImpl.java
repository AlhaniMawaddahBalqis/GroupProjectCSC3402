package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Patient;
import com.csc3402.project.pharmacysm.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient getPatientById(String patientId) {
        logger.info("Fetching patient with ID: {}", patientId);
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public Patient findPatientById(String patientId){
        return patientRepository.findPatientById(patientId);
    }

    @Override
    public List<Patient> listAllPatients() {
        logger.info("Fetching all patients");
        List<Patient> patients = patientRepository.findAll();
        logger.info("Fetched {} patients", patients.size());
        return patients;
    }

    @Override
    public void addPatient(Patient patient) {
        logger.info("Adding patient: {}", patient);
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        logger.info("Updating patient: {}", patient);
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String patientId) {
        logger.info("Deleting patient with ID: {}", patientId);
        patientRepository.deleteById(patientId);
    }
}
