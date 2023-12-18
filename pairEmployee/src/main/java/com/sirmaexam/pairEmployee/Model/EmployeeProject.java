package com.sirmaexam.pairEmployee.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employee_project")
public class EmployeeProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmpId;
    private Long ProjectId;
    private LocalDate DateFrom;
    private LocalDate DateTo;

    public Long getEmpId() {
        return EmpId;
    }

    public void setEmpId(Long empId) {
        EmpId = empId;
    }

    public Long getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Long projectId) {
        ProjectId = projectId;
    }

    public LocalDate getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        DateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return DateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        DateTo = dateTo;
    }

    public EmployeeProject(Long empID, Long projectID, LocalDate dateFrom, LocalDate dateTo) {
        EmpId = empID;
        ProjectId = projectID;
        DateFrom = dateFrom;
        DateTo = dateTo;
    }

    public EmployeeProject(){}
}
