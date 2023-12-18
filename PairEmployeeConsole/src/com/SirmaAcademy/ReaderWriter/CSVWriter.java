package com.sirmaexam.pairEmployee.ReaderWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CSVWriter implements CustomWriter {
    @Override
    public void write(List<Serializable> employees, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Serializable employee : employees) {
                writer.write(employee.toString() + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
