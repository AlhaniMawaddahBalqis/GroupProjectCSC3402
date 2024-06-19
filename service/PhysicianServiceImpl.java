package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Physician;
import com.csc3402.lab.pharmacy.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicianServiceImpl implements PhysicianService {

    private final PhysicianRepository physicianRepository;

    @Autowired
    public PhysicianServiceImpl(PhysicianRepository physicianRepository) {
        this.physicianRepository = physicianRepository;
    }

    @Override
    public List<Physician> listAllPhysicians() {

        return physicianRepository.findAll();
    }

    @Override
    public void addPhysician(Physician physician) {

        physicianRepository.save(physician);
    }

    @Override
    public Physician getPhysicianById(String physicianId) {
        return physicianRepository.findById(physicianId).orElse(null);
    }

    @Override
    public void updatePhysician(Physician physician) {

        physicianRepository.save(physician);
    }

    @Override
    public void deletePhysician(String physicianId) {

        physicianRepository.deleteById(physicianId);
    }
}
