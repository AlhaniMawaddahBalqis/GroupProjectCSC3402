package com.csc3402.project.pharmacysm.repository;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, String> {
    Pharmacist findByEmail(String email);

    Pharmacist findByPharmacistId(String pharmacistId);

    @Query(value = "SELECT * FROM pharmacist where pharmacist_id = :id", nativeQuery = true)
    Pharmacist findPharmacistById(@Param("id") String pharmacistId);

}
