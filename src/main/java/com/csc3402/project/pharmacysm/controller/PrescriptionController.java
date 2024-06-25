package com.csc3402.project.pharmacysm.controller;

import com.csc3402.project.pharmacysm.model.*;
import com.csc3402.project.pharmacysm.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionServiceImpl.class);

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PhysicianService physicianService;

    @Autowired
    private PharmacistService pharmacistService;

    @Autowired
    private MedicationService medicationService;

    @GetMapping("/add")
    public String showAddPrescriptionForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        List<Patient> patients = patientService.listAllPatients();
        List<Physician> physicians = physicianService.listAllPhysicians();
        List<Pharmacist> pharmacists = pharmacistService.listAllPharmacists();
        List<Medication> medications = medicationService.listAllMedication();

        LOGGER.info("Fetched patients: " + patients);
        LOGGER.info("Fetched physicians: " + physicians);
        LOGGER.info("Fetched pharmacists: " + pharmacists);
        LOGGER.info("Fetched medications: " + medications);

        model.addAttribute("patients", patients);
        model.addAttribute("physicians", physicians);
        model.addAttribute("pharmacists", pharmacists);
        model.addAttribute("medications", medications);
        return "add-prescription";
    }

    @PostMapping("/add")
    public String createPrescription(@Valid @ModelAttribute("prescription") Prescription prescription, BindingResult result, Model model) {
        if (result.hasErrors()) {
            LOGGER.info("Validation errors: {}", result.getAllErrors());
            model.addAttribute("patients", patientService.listAllPatients());
            model.addAttribute("physicians", physicianService.listAllPhysicians());
            model.addAttribute("pharmacists", pharmacistService.listAllPharmacists());
            model.addAttribute("medications", medicationService.listAllMedication());
            return "add-prescription";
        }

        Patient patient = patientService.findPatientById(prescription.getPatient().getPatientId());
        Medication medication = medicationService.findMedicationById(prescription.getMedication().getMedId());
        Physician physician = physicianService.findPhysicianById(prescription.getPhysician().getPhysicianId());
        Pharmacist pharmacist = pharmacistService.findPharmacistById(prescription.getPharmacist().getPharmacistId());

        prescription.setPatient(patient);
        prescription.setMedication(medication);
        prescription.setPhysician(physician);
        prescription.setPharmacist(pharmacist);

        prescription.setPrescDate(LocalDate.parse(prescription.getPrescDate().toString())); // Convert string to LocalDate

        prescriptionService.createPrescription(prescription);
        return "redirect:/prescriptions/list";
    }

    @GetMapping("/list")
    public String showPrescriptionList(Model model) {
        List<Prescription> prescriptions = prescriptionService.listAllPrescriptions();
        LOGGER.info("Fetched prescriptions: " + prescriptions);
        model.addAttribute("prescriptions", prescriptions);
        return "list-prescription";
    }

    @GetMapping("/edit/{prescId}")
    public String showEditForm(@PathVariable String prescId, Model model) {
        try {
            Prescription prescription = prescriptionService.getPrescriptionById(prescId);
            LOGGER.info("Fetched prescription: " + prescription);
            model.addAttribute("prescription", prescription);
            model.addAttribute("physicians", physicianService.listAllPhysicians());
            model.addAttribute("patients", patientService.listAllPatients());
            model.addAttribute("medications", medicationService.listAllMedication());
            return "update-prescription";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error fetching prescription: " + e.getMessage());
            return "redirect:/prescriptions/list";
        }
    }

    @PostMapping("/update")
    public String updatePrescription(@Valid @ModelAttribute("prescription") Prescription prescription, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("physicians", physicianService.listAllPhysicians());
            model.addAttribute("patients", patientService.listAllPatients());
            model.addAttribute("medications", medicationService.listAllMedication());
            return "update-prescription";
        }

        try {
            prescriptionService.updatePrescription(prescription);
            return "redirect:/prescriptions/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error updating prescription: " + e.getMessage());
            return "update-prescription";
        }
    }

    @PostMapping({"/delete/{prescId}"})
    public String deletePrescription(@PathVariable String prescId) {
        try {
            this.prescriptionService.deletePrescription(prescId);
            LOGGER.info("Deleted prescription with ID: " + prescId);
        } catch (Exception e) {
            LOGGER.error("Error deleting prescription with ID: " + prescId, e);
            e.printStackTrace();
        }
        return "redirect:/prescriptions/list";
    }


    @PostMapping("/complete/{prescId}")
    public String completePrescription(@PathVariable String prescId, Model model) {
        try {
            Prescription prescription = prescriptionService.getPrescriptionById(prescId);
            prescription.setStatus("Complete");
            prescriptionService.updatePrescription(prescription);
            return "redirect:/prescriptions/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error completing prescription: " + e.getMessage());
            return showPrescriptionList(model);
        }
    }
}
