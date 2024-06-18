package com.csc3402.project.pharmacy.repository;

import com.csc3402.project.pharmacy.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, String> {
    Pharmacist findByEmail(String email);

    Pharmacist findByPharmacistId(String pharmacistId);
}
