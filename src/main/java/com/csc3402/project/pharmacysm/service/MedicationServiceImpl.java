package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication getMedicationById(String medicationId) {
        return medicationRepository.findById(medicationId).orElse(null);
    }

    @Override
    public List<Medication> listAllMedication() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication findMedicationById(String medId){
        return medicationRepository.findMedicationById(medId);
    }

    @Override
    public void addMedication(Medication medication) {

        medicationRepository.save(medication);
    }

    @Override
    public void updateMedication(Medication medication) {

        medicationRepository.save(medication);
    }

    @Override
    public void deleteMedication(String medicationId) {
        medicationRepository.deleteById(medicationId);
    }
    public void save(Medication medication) {
        medicationRepository.save(medication);
    }
}
