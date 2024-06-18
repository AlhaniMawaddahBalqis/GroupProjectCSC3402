package com.csc3402.project.pharmacy.service;

import com.csc3402.project.pharmacy.dto.PharmacistDto;
import com.csc3402.project.pharmacy.model.Pharmacist;
import com.csc3402.project.pharmacy.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Pharmacist findPharmacistByEmail(String email) {
        return pharmacistRepository.findByEmail(email);
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

}
