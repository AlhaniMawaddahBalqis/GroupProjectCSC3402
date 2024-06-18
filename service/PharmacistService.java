package com.csc3402.project.pharmacy.service;

import com.csc3402.project.pharmacy.dto.PharmacistDto;
import com.csc3402.project.pharmacy.model.Pharmacist;

public interface PharmacistService {
    Pharmacist findPharmacistByEmail(String email);
    void savePharmacist(PharmacistDto pharmacistDto);
    void updatePharmacist(Pharmacist pharmacist);

}
