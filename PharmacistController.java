package com.csc3402.project.pharmacy.controller;

import com.csc3402.project.pharmacy.model.Pharmacist;
import com.csc3402.project.pharmacy.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pharmacist-profile")
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping
    public String getPharmacistProfile(Model model, Authentication authentication) {
        String email = authentication.getName();  // Retrieve logged-in user's email
        Pharmacist pharmacist = pharmacistService.findPharmacistByEmail(email);
        if (pharmacist != null) {
            model.addAttribute("pharmacist", pharmacist);
            return "pharmacist-profile";
        } else {
            model.addAttribute("error", "Pharmacist not found");
            return "error";
        }
    }

    @GetMapping("/update")
    public String getUpdatePharmacistProfile(Model model, Authentication authentication) {
        String email = authentication.getName();  // Retrieve logged-in user's email
        Pharmacist pharmacist = pharmacistService.findPharmacistByEmail(email);
        if (pharmacist != null) {
            model.addAttribute("pharmacist", pharmacist);
            return "update-pharmacist-profile";
        } else {
            model.addAttribute("error", "Pharmacist not found");
            return "error";
        }
    }

    @PostMapping("/update")
    public String updatePharmacistProfile(Pharmacist pharmacist, Authentication authentication) {
        String email = authentication.getName();  // Retrieve logged-in user's email
        Pharmacist existingPharmacist = pharmacistService.findPharmacistByEmail(email);
        if (existingPharmacist != null) {
            pharmacist.setPharmacistId(existingPharmacist.getPharmacistId());
            pharmacistService.updatePharmacist(pharmacist);
            return "redirect:/pharmacist-profile";
        } else {
            return "error";
        }
    }

}
