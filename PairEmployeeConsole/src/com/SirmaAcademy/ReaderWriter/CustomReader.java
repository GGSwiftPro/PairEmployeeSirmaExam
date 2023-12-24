package com.SirmaAcademy.ReaderWriter;

import com.SirmaAcademy.Client.EmployeeProject;

import java.io.Serializable;
import java.util.List;

public interface CustomReader {
    public List<EmployeeProject> read (String filename);
}
