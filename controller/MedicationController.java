package com.csc3402.lab.pharmacy.controller;

import com.csc3402.lab.pharmacy.model.Medication;
import com.csc3402.lab.pharmacy.model.Patient;
import com.csc3402.lab.pharmacy.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public String showAddMedicationForm() {
        return "add-medication";
    }

    @PostMapping("/add")
    public String addMedication(@RequestParam("medId") String medId,
                                @RequestParam("name") String name,
                                @RequestParam("brand") String brand,
                                @RequestParam("expDate") String expDate,
                                @RequestParam("quantity") int quantity){
        try {
            Medication medication = new Medication(medId, name, brand, LocalDate.parse(expDate), quantity);
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

    @GetMapping("/update")
    public String showUpdateForm(@ModelAttribute("medication") Medication medication, Model model) {
        model.addAttribute("medication", medication);
        return "update-medication";
    }

    @PostMapping("/update")
    public String updateMedication(@ModelAttribute("medication") Medication medication) {
        medicationService.updateMedication(medication);
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
