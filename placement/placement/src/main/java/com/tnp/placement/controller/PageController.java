package com.tnp.placement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/students")
    public String students() {
        return "students";
    }

    @GetMapping("/recruiters")
    public String recruiters() {
        return "recruiters";
    }

    @GetMapping("/placements")
    public String placements() {
        return "placements";
    }
}
