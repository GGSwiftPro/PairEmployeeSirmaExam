package com.SirmaAcademy.ReaderWriter;


import com.SirmaAcademy.Client.EmployeeProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CSVWriter implements CustomWriter {
    @Override
    public void write(List<EmployeeProject> employees, String filename) {
        try (FileWriter writer = new FileWriter(filename,true)) {
            for (Serializable employee : employees) {
                writer.append(employee.toString() + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
