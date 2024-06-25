package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.dto.PharmacistDto;
import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Pharmacist;

import java.util.List;

public interface PharmacistService {
    Pharmacist findPharmacistByEmail(String email);

    Pharmacist getPharmacistById(String pharmacistId);
    void savePharmacist(PharmacistDto pharmacistDto);
    void updatePharmacist(Pharmacist pharmacist);

    Pharmacist findPharmacistById(String pharmacistId);


    List<Pharmacist> listAllPharmacists();

}
