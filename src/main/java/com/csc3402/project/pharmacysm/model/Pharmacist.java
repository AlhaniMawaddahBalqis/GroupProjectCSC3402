package com.csc3402.project.pharmacysm.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pharmacist")
public class Pharmacist {

    @Id
    @Column(name = "pharmacist_id")
    private String pharmacistId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "pharmacist", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

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

    public Pharmacist(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
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

    @Override
    public String toString() {
        return "Pharmacist{" +
                "pharmacistId='" + pharmacistId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
