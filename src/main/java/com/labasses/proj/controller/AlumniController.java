package com.labasses.proj.controller;


import com.labasses.proj.model.Alumni;
import com.labasses.proj.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumni")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping
    public List<Alumni> getAll() {
        return alumniService.getAll();
    }

    @GetMapping("/{id}")
    public Alumni getById(@PathVariable Long id) {
        return alumniService.getById(id);
    }

    @GetMapping("/year/{year}")
    public List<Alumni> getByBatch(@PathVariable String year) {
        return alumniService.getByBatch(year);
    }

    @PostMapping
    public Alumni create(@RequestBody Alumni alumni) {
        return alumniService.create(alumni);
    }

    @PutMapping("/{id}")
    public Alumni update(@PathVariable Long id, @RequestBody Alumni alumni) {
        return alumniService.update(id, alumni);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumniService.delete(id);
    }
    @PostMapping("/alumni/update/{id}")
    public String updateAlumni(@PathVariable Long id, @ModelAttribute Alumni alumni) {
    alumniService.update(id, alumni);
    return "redirect:/alumni/view";
    }
    @DeleteMapping("/alumni/{id}")
    public ResponseEntity<Void> deleteAlumni(@PathVariable Long id) {
    alumniService.delete(id);
    return ResponseEntity.noContent().build();
}

}

