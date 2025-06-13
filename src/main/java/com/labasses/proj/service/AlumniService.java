package com.labasses.proj.service;

import com.labasses.proj.model.Alumni;
import java.util.List;

public interface AlumniService {
    List<Alumni> getAll();
    Alumni getById(Long id);
    List<Alumni> getByBatch(String batch);
    Alumni create(Alumni alumni);
    Alumni update(Long id, Alumni alumni);
    void delete(Long id);
}
