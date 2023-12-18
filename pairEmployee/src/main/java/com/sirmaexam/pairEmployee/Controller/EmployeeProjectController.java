package com.sirmaexam.pairEmployee.Controller;

import com.sirmaexam.pairEmployee.Model.EmployeeProject;
import com.sirmaexam.pairEmployee.Service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee-projects")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @GetMapping("/{empID}")
    public List<EmployeeProject> getEmployeeProjects(@PathVariable Long empId) {
        return employeeProjectService.getEmployeeProjects(empId);
    }
}