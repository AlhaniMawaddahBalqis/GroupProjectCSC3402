package com.csc3402.project.pharmacysm.controller;

import com.csc3402.project.pharmacysm.model.Patient;
import com.csc3402.project.pharmacysm.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public String showPatientList(Model model) {
        List<Patient> patients = patientService.listAllPatients();
        model.addAttribute("patients", patients);
        return "list-patient";
    }

    @GetMapping("/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add")
    public String addPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "add-patient";
        }
        try {
            patientService.addPatient(patient);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/patients/list";
    }

    @GetMapping("/edit/{patientId}")
    public String showEditPatientForm(@PathVariable String patientId, Model model) {
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("/update")
    public String updatePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "update-patient";
        }
        try {
            patientService.updatePatient(patient);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/patients/list";
    }

    @PostMapping("/delete/{patientId}")
    public String deletePatient(@PathVariable String patientId) {
        try {
            patientService.deletePatient(patientId);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/patients/list";
    }
}
