package com.company.services;

import com.company.models.Check;

import java.util.List;

public interface CheckService {

    String save(Check check);
    List<Check> findList();
    Check findById(String check);
    void updateSeller (long id, double total);
}
