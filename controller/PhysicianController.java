package com.csc3402.lab.pharmacy.controller;

import com.csc3402.lab.pharmacy.model.Physician;
import com.csc3402.lab.pharmacy.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/physicians")
public class PhysicianController {

    private final PhysicianService physicianService;

    @Autowired
    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    @GetMapping("/list")
    public String showPhysicianList(Model model) {
        List<Physician> physicians = physicianService.listAllPhysicians();
        model.addAttribute("physicians", physicians);
        return "list-physician";
    }



    @GetMapping("/add")
    public String showAddPhysicianForm() {
        return "add-physician";
    }

    @PostMapping("/add")
    public String addPhysician(@RequestParam("physicianId") String physicianId,
                               @RequestParam("name") String name,
                               @RequestParam("contactNo") String contactNo,
                               @RequestParam("email") String email,
                               @RequestParam("prescdate") String prescdate) {
        try {
            Physician physician = new Physician(physicianId, name, contactNo, email, LocalDate.parse(prescdate));
            physicianService.addPhysician(physician);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/physicians/list";
    }

    @GetMapping("/edit/{physicianId}")
    public String showEditPhysicianForm(@PathVariable String physicianId, Model model) {
        Physician physician = physicianService.getPhysicianById(physicianId);
        model.addAttribute("physician", physician);
        return "update-physician";
    }

    @PostMapping("/update")
    public String updatePhysician(@ModelAttribute Physician physician) {
        try {
            physicianService.updatePhysician(physician);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/physicians/list";
    }

    @PostMapping("/delete/{physicianId}")
    public String deletePhysician(@PathVariable String physicianId) {
        try {
            physicianService.deletePhysician(physicianId);
        } catch (Exception e) {
            e.printStackTrace();
            // Add proper error handling here
        }
        return "redirect:/physicians/list";
    }
}
