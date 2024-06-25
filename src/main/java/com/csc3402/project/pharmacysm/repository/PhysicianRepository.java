package com.csc3402.project.pharmacysm.repository;

import com.csc3402.project.pharmacysm.model.Medication;
import com.csc3402.project.pharmacysm.model.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, String> {
    @Query(value = "SELECT * FROM physician where physician_id = :id", nativeQuery = true)
    Physician findPhysicianById(@Param("id") String physician);
}
