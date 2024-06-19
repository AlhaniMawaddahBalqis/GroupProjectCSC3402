package com.csc3402.lab.pharmacy.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class PrescriptionMedicationKey implements Serializable {

    private String prescriptionId;
    private String medId;

    // Constructors, getters, setters, equals(), and hashCode() methods

    public PrescriptionMedicationKey() {}

    public PrescriptionMedicationKey(String prescriptionId, String medId) {
        this.prescriptionId = prescriptionId;
        this.medId = medId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionMedicationKey that = (PrescriptionMedicationKey) o;
        return Objects.equals(prescriptionId, that.prescriptionId) && Objects.equals(medId, that.medId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, medId);
    }

    @Override
    public String toString() {
        return "PrescriptionMedicationKey{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", medId='" + medId + '\'' +
                '}';
    }
}
