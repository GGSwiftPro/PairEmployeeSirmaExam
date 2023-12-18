package com.sirmaexam.pairEmployee.Service;

import com.sirmaexam.pairEmployee.Model.EmployeeProject;
import com.sirmaexam.pairEmployee.Repository.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public List<EmployeeProject> getEmployeeProjects(Long empID) {
        return employeeProjectRepository.findAllByEmpId(empID).stream().toList();
    }

    public List<EmployeeProject> getEmployeeProjects1(Long empID) {
        return employeeProjectRepository.findById(empID).stream().toList();
    }


   // public void addEmployee()

    //TODO Add project
    //TODO Add employee
    //TODO Edit project & employee
    //TODO Delete project & employee
    //TODO Show all projects
    //TODO Show all employees
    //TODO Show all ordered

}