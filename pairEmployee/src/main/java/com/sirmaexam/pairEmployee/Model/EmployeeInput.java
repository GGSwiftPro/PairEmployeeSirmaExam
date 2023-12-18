package com.sirmaexam.pairEmployee.Model;

import jakarta.persistence.*;

import java.io.Serializable;

public class EmployeeInput implements Serializable {

    private Long EmpID;
    private Long ProjectID;
    private String DateFrom;
    private String DateTo;

    public Long getEmpID() {
        return EmpID;
    }

    public void setEmpID(Long empID) {
        EmpID = empID;
    }

    public Long getProjectID() {
        return ProjectID;
    }

    public void setProjectID(Long projectID) {
        ProjectID = projectID;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }

    public EmployeeInput(Long empID, Long projectID, String dateFrom, String dateTo) {
        EmpID = empID;
        ProjectID = projectID;
        DateFrom = dateFrom;
        DateTo = dateTo;
    }

    public EmployeeInput(){}
}
