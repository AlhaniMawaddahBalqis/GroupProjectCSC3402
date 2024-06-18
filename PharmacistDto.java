package com.csc3402.project.pharmacy.dto;

import jakarta.validation.constraints.NotEmpty;

public class PharmacistDto {
    private String pharmacistId;

    @NotEmpty(message = "Please enter valid name.")
    private String name;

    @NotEmpty(message = "Please enter valid email.")
    private String email;

    @NotEmpty(message = "Please enter valid contact number.")
    private String contactNo;

    @NotEmpty(message = "Please enter valid password.")
    private String password;

    public PharmacistDto() {}

    public PharmacistDto(String pharmacistId, String name, String email, String contactNo, String password) {
        this.pharmacistId = pharmacistId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
    }

    // getters and setters

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
        return "PharmacistDto{" +
                "pharmacistId='" + pharmacistId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
