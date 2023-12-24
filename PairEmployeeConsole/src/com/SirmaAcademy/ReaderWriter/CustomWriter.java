package com.SirmaAcademy.ReaderWriter;

import com.SirmaAcademy.Client.EmployeeProject;

import java.io.Serializable;
import java.util.List;

public interface CustomWriter {
    void write (List<EmployeeProject> employees, String filename);
}
