package com.csc3402.lab.pharmacy.model;

import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.model.PrescriptionMedication;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
    @Id
    @Column(name = "presc_id")
    private String prescId;



    // Many-to-one relationship with Patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Many-to-one relationship with Physician
    @ManyToOne
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;
    @Column(name = "presc_date")
    private LocalDate prescDate;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<PrescriptionMedication> prescriptionMedications = new HashSet<>();

    // Getters and setters

    public String getPrescId() {
        return prescId;
    }

    public void setPrescId(String prescId) {
        this.prescId = prescId;
    }

    public LocalDate getPrescDate() {
        return prescDate;
    }

    public void setPrescDate(LocalDate prescDate) {
        this.prescDate = prescDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Set<PrescriptionMedication> getPrescriptionMedications() {
        return prescriptionMedications;
    }
    public void setPrescriptionMedications(Set<PrescriptionMedication> prescriptionMedications) {
        this.prescriptionMedications = prescriptionMedications;
    }
    public void setId(String id) {
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescId='" + prescId + '\'' +
                ", patient=" + patient +
                ", physician=" + physician +
                ", pharmacist=" + pharmacist +
                ", prescDate=" + prescDate +
                ", prescriptionMedications=" + prescriptionMedications +
                '}';
    }
}
