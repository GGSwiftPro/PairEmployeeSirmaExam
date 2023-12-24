package com.SirmaAcademy.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeProject implements Serializable {
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

    public LocalDate getDateToOrToday(){
        if (this.getDateTo()==null)return LocalDate.now();
        return getDateTo();
    }

    public EmployeeProject(Long empID, Long projectID, LocalDate dateFrom, LocalDate dateTo) {
        EmpId = empID;
        ProjectId = projectID;
        DateFrom = dateFrom;
        DateTo = dateTo;
    }

    public EmployeeProject(){}
    public String Information(){
        return  toString();
    }

    @Override
    public String toString() {
        return   EmpId +
                " ," + ProjectId +
                " ,"  + DateFrom +
                " ," + DateTo;
    }
}
