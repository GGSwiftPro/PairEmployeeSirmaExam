package com.SirmaAcademy.ReaderWriter;

import com.SirmaAcademy.Employee.EmployeeProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements CustomReader {

    @Override
    public List<EmployeeProject> read(String filename) {

        List<EmployeeProject> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //  TODO check for headers!

            while ((line = br.readLine()) != null) {
                String[] values = line.replace(" ","").split(",");
                //  TODO validations for input data
                Long empId= Long.parseLong(values[0]);
                Long projectId=Long.parseLong(values[1]);
                LocalDate dateFrom = LocalDate.parse(values[2]);
                LocalDate dateTo = "null".equalsIgnoreCase(values[3]) ? null : LocalDate.parse(values[3]);

                employees.add(new EmployeeProject(empId, projectId, dateFrom,dateTo));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
