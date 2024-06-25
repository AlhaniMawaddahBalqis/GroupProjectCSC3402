package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.dto.PharmacistDto;
import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Pharmacist;
import com.csc3402.project.pharmacysm.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Pharmacist findPharmacistByEmail(String email) {
        Pharmacist pharmacist = pharmacistRepository.findByEmail(email);
        if (pharmacist == null) {
            throw new IllegalArgumentException("Pharmacist with email " + email + " not found");
        }
        return pharmacist;
    }

    @Override
    public Pharmacist getPharmacistById(String pharmacistId) {
        return pharmacistRepository.findByPharmacistId(pharmacistId);
    }

    @Override
    public Pharmacist findPharmacistById(String pharmacistId){
        return pharmacistRepository.findPharmacistById(pharmacistId);
    }


    @Override
    public void savePharmacist(PharmacistDto pharmacistDto) {

        if (pharmacistRepository.findByEmail(pharmacistDto.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        Pharmacist pharmacist = new Pharmacist(
                pharmacistDto.getPharmacistId(),
                pharmacistDto.getName(),
                pharmacistDto.getEmail(),
                pharmacistDto.getContactNo(),
                passwordEncoder.encode(pharmacistDto.getPassword())
        );

        pharmacistRepository.save(pharmacist);
    }

    @Override
    public void updatePharmacist(Pharmacist pharmacist) {
        Pharmacist existingPharmacist = pharmacistRepository.findByPharmacistId(pharmacist.getPharmacistId());
        if (existingPharmacist != null) {
            existingPharmacist.setName(pharmacist.getName());
            existingPharmacist.setContactNo(pharmacist.getContactNo());
            existingPharmacist.setEmail(pharmacist.getEmail());
            pharmacistRepository.save(existingPharmacist);
        } else {
            throw new IllegalArgumentException("Pharmacist not found");
        }
    }

    @Override
    public List<Pharmacist> listAllPharmacists() {
        return pharmacistRepository.findAll();
    }

}
