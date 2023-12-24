package com.SirmaAcademy.ReaderWriter;

import com.SirmaAcademy.Employee.EmployeeProject;

import java.util.List;

public interface CustomReader {
    public List<EmployeeProject> read (String filename);
}
