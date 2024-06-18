package com.csc3402.project.pharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pharmacists")
public class Pharmacist {

    @Id
    private String pharmacistId;
    private String name;
    private String email;
    private String contactNo;
    private String password;

    // Default no-argument constructor
    public Pharmacist() {
    }

    // Parameterized constructor
    public Pharmacist(String pharmacistId, String name, String email, String contactNo, String password) {
        this.pharmacistId = pharmacistId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
    }

    // Getters and Setters

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
