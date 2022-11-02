package com.company.services;

import com.company.models.Check;

import java.util.List;

public interface CheckService {

    void save(Check check);
    List<Check> findList();
    Check findById(Long id);
}
