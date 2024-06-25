package com.csc3402.project.pharmacysm.repository;

import com.csc3402.project.pharmacysm.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {
    @Query(value = "SELECT * FROM medication where med_id = :id", nativeQuery = true)
    Medication findMedicationById(@Param("id") String medId);
}
