package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Physician;

import java.util.List;

public interface PhysicianService {
    List<Physician> listAllPhysicians();
    void addPhysician(Physician physician);
    Physician getPhysicianById(String physicianId);
    void updatePhysician(Physician physician);
    void deletePhysician(String physicianId);

    Physician findPhysicianById(String physicianId);

}
