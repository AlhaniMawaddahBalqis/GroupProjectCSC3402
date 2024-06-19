package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Medication;
import com.csc3402.lab.pharmacy.repository.MedicationRepository;
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
