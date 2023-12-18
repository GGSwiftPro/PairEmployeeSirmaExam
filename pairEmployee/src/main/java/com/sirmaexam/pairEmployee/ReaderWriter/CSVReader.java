package com.sirmaexam.pairEmployee.ReaderWriter;


import com.sirmaexam.pairEmployee.Model.EmployeeProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements CustomReader {

    @Override
    public List<? extends Serializable> read(String filename) {
        List<EmployeeProject> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //  TODO check for headers!

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                //  TODO validations for input data
                employees.add(new EmployeeProject(Long.parseLong(values[0]), Long.parseLong(values[1]), LocalDate.parse(values[2]),LocalDate.parse(values[3])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
