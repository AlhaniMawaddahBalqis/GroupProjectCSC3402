package com.csc3402.project.pharmacysm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MEDICATION")
public class Medication {

    @Id
    @Column(name = "med_id")
    private String medId;

    @NotEmpty(message = "Name is required")
    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "exp_date")
    private LocalDate expDate;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;


    public Medication() {
    }

    public Medication(String medId, String name, String brand, LocalDate expDate, int quantity, List<Prescription> prescriptions) {
        this.medId = medId;
        this.name = name;
        this.brand = brand;
        this.expDate = expDate;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medId='" + medId + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", expDate=" + expDate + '\'' +
                ", quantity=" + quantity + '\'' +
                '}';
    }
}
