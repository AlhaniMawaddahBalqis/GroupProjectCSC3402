package com.csc3402.lab.pharmacy.repository;

import com.csc3402.lab.pharmacy.model.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, String> {
}
