package com.csc3402.project.pharmacy.controller;

import com.csc3402.project.pharmacy.dto.PharmacistDto;
import com.csc3402.project.pharmacy.model.Pharmacist;
import com.csc3402.project.pharmacy.service.PharmacistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping("/")
    public String starter(){
        return "landing-page";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("pharmacist", new Pharmacist());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPharmacist(
            @Valid @ModelAttribute("pharmacist") PharmacistDto pharmacistDto, BindingResult result, Model model) {
        Pharmacist existingPharmacist = pharmacistService.findPharmacistByEmail(pharmacistDto.getEmail());

        if (existingPharmacist != null)
            result.rejectValue("email", null,
                    "Pharmacist already registered!");

        if (result.hasErrors()){
            model.addAttribute("pharmacist", pharmacistDto);
            return "/registration";
        }
        pharmacistService.savePharmacist(pharmacistDto);
        return "redirect:/registration?success";
    }




}
