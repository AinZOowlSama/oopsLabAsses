package com.labasses.proj.service;


import com.labasses.proj.model.Alumni;
import com.labasses.proj.repository.AlumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumniServiceImpl implements AlumniService {

    @Autowired
    private AlumniRepository alumniRepository;

    @Override
    public List<Alumni> getAll() {
        return alumniRepository.findAll();
    }

    @Override
    public Alumni getById(Long id) {
        return alumniRepository.findById(id).orElse(null);
    }

    @Override
    public List<Alumni> getByBatch(String batch) {
        return alumniRepository.findByBatch(batch);
    }

    @Override
    public Alumni create(Alumni alumni) {
        return alumniRepository.save(alumni);
    }

    @Override
    public Alumni update(Long id, Alumni alumni) {
        Alumni existing = alumniRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(alumni.getName());
            existing.setBatch(alumni.getBatch());
            existing.setCompany(alumni.getCompany());
            existing.setContact(alumni.getContact());
            return alumniRepository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        alumniRepository.deleteById(id);
    }
}


