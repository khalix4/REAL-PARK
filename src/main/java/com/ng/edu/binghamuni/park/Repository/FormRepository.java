package com.ng.edu.binghamuni.park.Repository;

import com.ng.edu.binghamuni.park.Domain.FormExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository <FormExample, Long> {

    @Override
    List<FormExample> findAll();
}
