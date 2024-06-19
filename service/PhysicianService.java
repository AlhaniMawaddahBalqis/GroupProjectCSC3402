package com.csc3402.lab.pharmacy.service;

import com.csc3402.lab.pharmacy.model.Physician;
import java.util.List;

public interface PhysicianService {
    List<Physician> listAllPhysicians();
    void addPhysician(Physician physician);
    Physician getPhysicianById(String physicianId);
    void updatePhysician(Physician physician);
    void deletePhysician(String physicianId);
}
