package com.SirmaAcademy.ReaderWriter;

import com.SirmaAcademy.Employee.EmployeeProject;

import java.util.List;

public interface CustomWriter {
    void write (List<EmployeeProject> employees, String filename);
}
