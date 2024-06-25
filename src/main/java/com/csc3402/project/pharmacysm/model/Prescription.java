package com.csc3402.project.pharmacysm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
    @Id
    @Column(name = "presc_id")
    private String prescId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "med_id")
    private Medication medication;

    @ManyToOne
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;

    @Column(name = "dosage", nullable = false)
    @NotBlank
    private String dosage;

    @Column(name = "presc_date", nullable = false)
    @NotNull
    private LocalDate prescDate;

    @Column(name = "status", nullable = false)
    @NotBlank
    private String status;

    // Constructors, getters, setters, and toString() method
    public Prescription() {
    }

    public Prescription(String prescId, Patient patient, Medication medication, Physician physician,
                        Pharmacist pharmacist, LocalDate prescDate, String status, String dosage) {
        this.prescId = prescId;
        this.patient = patient;
        this.medication = medication;
        this.physician = physician;
        this.pharmacist = pharmacist;
        this.prescDate = prescDate;
        this.status = status;
        this.dosage = dosage;
    }

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

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescId='" + prescId + '\'' +
                ", patient=" + patient +
                ", medication=" + medication +
                ", physician=" + physician +
                ", pharmacist=" + pharmacist +
                ", dosage='" + dosage + '\'' +
                ", prescDate=" + prescDate +
                ", status='" + status + '\'' +
                '}';
    }
}
