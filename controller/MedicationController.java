package com.csc3402.lab.pharmacy.controller;

import com.csc3402.lab.pharmacy.model.Medication;
import com.csc3402.lab.pharmacy.service.MedicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/add")
    public String showAddMedicationForm(Model model) {
        model.addAttribute("medication", new Medication());
        return "add-medication";
    }

    @PostMapping("/add")
    public String addMedication(@Valid @ModelAttribute("medication") Medication medication, BindingResult result) {
        if (result.hasErrors()) {
            return "add-medication";
        }
        try {
            medicationService.addMedication(medication);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/medications/list";
    }

    @GetMapping("/list")
    public String showMedicationList(Model model) {
        List<Medication> medications = medicationService.listAllMedication();
        model.addAttribute("medications", medications);
        return "list-medication";
    }

    @GetMapping("/edit/{medId}")
    public String showEditMedicationForm(@PathVariable String medId, Model model) {
        Medication medication = medicationService.getMedicationById(medId);
        model.addAttribute("medication", medication);
        return "update-medication";
    }

    @PostMapping("/update")
    public String updateMedication(@Valid @ModelAttribute("medication") Medication medication, BindingResult result) {
        if (result.hasErrors()) {
            return "update-medication";
        }
        try {
            medicationService.updateMedication(medication);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/medications/list";
    }

    @PostMapping("/delete/{medId}")
    public String deleteMedication(@PathVariable String medId) {
        try {
            medicationService.deleteMedication(medId);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/medications/list";
    }
}
