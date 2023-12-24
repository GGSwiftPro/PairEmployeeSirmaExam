package com.SirmaAcademy.Starter;

import com.SirmaAcademy.Admin.AdminInterface;
import com.SirmaAcademy.Admin.EmployeeAdmin;
import com.SirmaAcademy.ReaderWriter.CSVReader;
import com.SirmaAcademy.ReaderWriter.CSVWriter;
import com.SirmaAcademy.ReaderWriter.CustomReader;
import com.SirmaAcademy.ReaderWriter.CustomWriter;
import com.SirmaAcademy.Service.EmployeeServiceImpl;
import com.SirmaAcademy.Service.EmployeeService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Implement file operations for XML/SQLite
        Scanner scanner = new Scanner(System.in);
        CustomReader fileReader = new CSVReader();
        CustomWriter fileWriter = new CSVWriter();

        EmployeeService service = new EmployeeServiceImpl(fileReader, fileWriter);
        AdminInterface admin = new EmployeeAdmin(service);
        int command;
        System.out.println("Welcome to the Employee-Project System");
        displayOptions();
        boolean active = true;
        while (active) {
            command = Integer.parseInt(scanner.next());
            admin.performAction(command);
            if (command == 7)
                active = false;
            else
                displayOptions();


        }
    }

    private static void displayOptions() {
        System.out.println("1. See all employee");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Search maxPair");
        System.out.println("5. Delete Employee");
        System.out.println("6. Search Employee by ID");
        System.out.println("7. Exit");


    }
}
