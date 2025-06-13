package com.labasses.proj.controller;


import com.labasses.proj.model.Alumni;
import com.labasses.proj.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlumniWebController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping("/alumni/view")
    public String viewAlumni(Model model) {
        model.addAttribute("alumniList", alumniService.getAll());
        return "alumni";
    }

    @GetMapping("/alumni/new")
    public String newAlumniForm(Model model) {
        model.addAttribute("alumni", new Alumni());
        return "alumni_form";
    }

    @PostMapping("/alumni/save")
    public String saveAlumni(@ModelAttribute Alumni alumni) {
        alumniService.create(alumni);
        return "redirect:/alumni/view";
    }
    @GetMapping("/alumni/edit/{id}")
    public String editAlumni(@PathVariable Long id, Model model) {
     Alumni alumni = alumniService.getById(id);
     model.addAttribute("alumni", alumni);
     return "alumni_form";  // reuse the same form for add/edit
    }

}

