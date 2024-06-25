package com.csc3402.project.pharmacysm.controller;

import com.csc3402.project.pharmacysm.model.Physician;
import com.csc3402.project.pharmacysm.service.PhysicianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String showAddPhysicianForm(Model model) {
        model.addAttribute("physician", new Physician());
        return "add-physician";
    }

    @PostMapping("/add")
    public String addPhysician(@Valid @ModelAttribute("physician") Physician physician, BindingResult result) {
        if (result.hasErrors()) {
            return "add-physician";
        }
        try {
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
    public String updatePhysician(@Valid @ModelAttribute("physician") Physician physician, BindingResult result) {
        if (result.hasErrors()) {
            return "update-physician";
        }
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
