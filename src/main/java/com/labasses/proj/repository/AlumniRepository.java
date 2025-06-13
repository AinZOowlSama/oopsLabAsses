package com.labasses.proj.repository;

import com.labasses.proj.model.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    List<Alumni> findByBatch(String batch);
}


