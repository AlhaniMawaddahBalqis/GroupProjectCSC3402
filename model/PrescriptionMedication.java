package com.csc3402.lab.pharmacy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRESCRIPTION_MEDICATION")
public class PrescriptionMedication {

    @EmbeddedId
    private PrescriptionMedicationKey id;

    @ManyToOne
    @MapsId("prescriptionId")
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @MapsId("medId")
    @JoinColumn(name = "med_id")
    private Medication medication;

    @Column(name = "dosage")
    private String dosage;

    public PrescriptionMedicationKey getId() {
        return id;
    }

    public void setId(PrescriptionMedicationKey id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "PrescriptionMedication{" +
                "id=" + id +
                ", prescription=" + prescription +
                ", medication=" + medication +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}
