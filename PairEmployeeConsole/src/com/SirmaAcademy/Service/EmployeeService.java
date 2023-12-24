package com.SirmaAcademy.Service;

import com.SirmaAcademy.Employee.EmployeeProject;

public interface EmployeeService {

    void  viewEmployees();
    void addEmployee(EmployeeProject employeeProject);
    void findLongestWorkingPairs();
    void updateEmployee(EmployeeProject oldEmployeeProject,EmployeeProject employeeProject);
    void search(Long empId);
    void removeEmployee(EmployeeProject employeeProject);
}
