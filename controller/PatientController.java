package com.csc3402.lab.pharmacy.controller;

import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String showAddPatientForm() {
        return "add-patient";
    }

    @PostMapping("/add")
    public String addPatient(@RequestParam("patientId") String patientId,
                             @RequestParam("name") String name,
                             @RequestParam("ic") String ic,
                             @RequestParam("dob") String dob,
                             @RequestParam("contact") String contact,
                             @RequestParam("gender") String gender) {
        try {
            Patient patient = new Patient(patientId, name, ic, LocalDate.parse(dob), contact, gender);
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
    public String updatePatient(@ModelAttribute Patient patient) {
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
