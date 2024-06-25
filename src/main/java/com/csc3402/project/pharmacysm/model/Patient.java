package com.csc3402.project.pharmacysm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "IC")
    private String ic;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "contact_no")
    private String contact;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prescription> prescriptions;

    // Constructors, getters, setters, toString() methods

    public Patient() {
    }

    public Patient(String patientId, String name, String ic, LocalDate dob, String contact, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.ic = ic;
        this.dob = dob;
        this.contact = contact;
        this.gender = gender;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", ic='" + ic + '\'' +
                ", dob=" + dob +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
