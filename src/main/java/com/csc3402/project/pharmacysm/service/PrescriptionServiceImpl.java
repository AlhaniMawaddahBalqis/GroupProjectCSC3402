package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.*;
import com.csc3402.project.pharmacysm.repository.PrescriptionRepository;
import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionServiceImpl.class);
    private final PrescriptionRepository prescriptionRepository;
    private final PharmacistService pharmacistService; // Assuming you have a PharmacistService

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, PharmacistService pharmacistService) {
        this.prescriptionRepository = prescriptionRepository;
        this.pharmacistService = pharmacistService;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public List<Prescription> listAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription savePrescription(Prescription prescription) {
        try {
            return prescriptionRepository.save(prescription);
        } catch (Exception e) {
            LOGGER.error("Error saving prescription: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Prescription findPrescriptionById(String prescId) {
        return prescriptionRepository.findById(prescId).orElse(null);
    }

    @Override
    public Prescription updatePrescription(Prescription prescription) {
        return savePrescription(prescription);
    }

    @Override
    public void deletePrescription(String prescId) {
        prescriptionRepository.deleteById(prescId);
    }

    @Override
    public List<Prescription> getPrescriptionsByPatient(Patient patient) {
        return prescriptionRepository.findByPatient(patient);
    }

    @Override
    public List<Prescription> getPrescriptionsByPhysician(Physician physician) {
        return prescriptionRepository.findByPhysician(physician);
    }

    @Override
    public List<Prescription> getPrescriptionsByPrescDate(LocalDate prescDate) {
        return prescriptionRepository.findByPrescDate(prescDate);
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        LOGGER.info("Creating prescription: {}", prescription);

        // Set pharmacist ID in prescription
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalEmail = authentication.getName();
        Pharmacist pharmacist = pharmacistService.findPharmacistByEmail(currentPrincipalEmail);
        prescription.setPharmacist(pharmacist);

        // Save prescription
        return prescriptionRepository.save(prescription);
    }
    @Override
    public Prescription getPrescriptionById(String prescId) {
        return findPrescriptionById(prescId);
    }

    @Override
    public List<Prescription> getPrescriptionsByMedication(Medication medication) {
        return prescriptionRepository.findByMedication(medication);
    }

    @Override
    public List<Prescription> getPrescriptionsByPharmacist(Pharmacist pharmacist) {
        return prescriptionRepository.findByPharmacist(pharmacist);
    }


}
