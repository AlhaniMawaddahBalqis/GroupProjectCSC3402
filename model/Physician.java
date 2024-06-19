package com.csc3402.lab.pharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "PHYSICIAN")
public class Physician {
    @Id
    @Column(name = "physician_id")
    private String physicianId;

    @Column(name = "physician_name")
    private String name;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "presc_date")
    private LocalDate prescdate;

    @OneToMany(mappedBy = "physician", cascade = CascadeType.ALL)
    private Set <Prescription> prescriptions;

    public Physician() {

    }
    public Physician(String physicianId,String name, String contactNo, String email, LocalDate prescdate) {
        this.physicianId = physicianId;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.prescdate = prescdate;
    }



    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {

        this.contactNo = contactNo;
    }


    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public LocalDate getPrescdate() {

        return prescdate;
    }

    public void setPrescdate(LocalDate prescdate) {
        this.prescdate = prescdate;
    }

    public Set<Prescription> getPrescriptions() {

        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {

        this.prescriptions = prescriptions;
    }

    @Override
    public String toString() {
        return "Physician{" +
                "physicianID='" + physicianId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", prescdate='" + prescdate + '\'' +
                ", prescriptions=" + prescriptions +
                '}';
    }
}