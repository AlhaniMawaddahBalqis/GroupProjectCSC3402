package com.csc3402.project.pharmacysm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Mapping for the index page
    @GetMapping("/index")
    public String index() {
        // Return the name of your index.html file
        return "index";
    }
}
