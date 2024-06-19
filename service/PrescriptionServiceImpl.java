package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.model.Physician;
import com.csc3402.lab.pharmacy.model.Prescription;
import com.csc3402.lab.pharmacy.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription findPrescriptionById(String id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    @Override
    public Prescription updatePrescription(String id, Prescription prescription) {
        if (prescriptionRepository.existsById(id)) {
            prescription.setId(id);
            prescriptionRepository.save(prescription);
        } else {
            throw new IllegalArgumentException("Prescription not found with ID: " + id);
        }
        return prescription;
    }

    @Override
    public void deletePrescription(String id) {
        prescriptionRepository.deleteById(id);
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
        return null;
    }

    @Override
    public Prescription getPrescriptionById(String id) {
        return null;
    }
}
