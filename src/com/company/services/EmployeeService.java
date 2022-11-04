package com.company.services;

import com.company.models.Employee;

import java.util.List;

public interface EmployeeService {
    void createSeller (Employee emp);
    List<Employee> empList();
    void updateSeller (int id);
    void deleteSeller (int id);

    Employee findById (int id);


}
