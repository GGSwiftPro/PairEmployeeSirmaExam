package com.SirmaAcademy.Admin;

import com.SirmaAcademy.Employee.EmployeeProject;
import com.SirmaAcademy.ReaderWriter.CSVReader;
import com.SirmaAcademy.ReaderWriter.CustomReader;
import com.SirmaAcademy.Service.EmployeeService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeAdmin implements AdminInterface {
    private EmployeeService service;
    CustomReader r = new CSVReader();
    List<EmployeeProject> employeeProjectList;

    public EmployeeAdmin(EmployeeService service) {
        this.service = service;
    }
    @Override
    public void performAction(int command) {
        switch (command) {
            case 1 -> {
                service.viewEmployees();
            }
            case 2 -> {
                Scanner scanner = new Scanner(System.in);
                Long empID,projectId;
                String dateFrom,dateTo = null;

                do {
                    System.out.println("Enter ID of employee you want to add: ");
                    try {
                        empID = scanner.nextLong();
                        if (empID < 0)
                            System.out.println("ID must be a positive integer. Please enter a valid ID.");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for ID.");
                        scanner.nextLine();
                        empID = Long.valueOf(-1);
                    } finally {
                        scanner.nextLine();
                    }
                } while (empID < 0);

                do {
                    System.out.println("Enter the projectID where the employee will work at: ");
                    try {
                        projectId = scanner.nextLong();
                        if (projectId < 0)
                            System.out.println("ProjectId must be a positive integer. Please enter a valid ID.");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for projectId.");
                        scanner.nextLine();
                        projectId = Long.valueOf(-1);
                    } finally {
                        scanner.nextLine();
                    }
                } while (projectId < 0);
                System.out.println("DateFrom: YYYY--MM--DD ");
                dateFrom= scanner.nextLine();
                do {
                    System.out.println("DateTo: YYYY--MM--DD ");
                    try {
                        dateTo = scanner.nextLine();
                        if (LocalDate.parse(dateTo).isBefore(LocalDate.parse(dateTo)))
                            System.out.println("DateTo must be after DateFrom!");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid date for dateTo.");
                        scanner.nextLine();
                    } finally {
                        scanner.nextLine();
                    }
                } while (dateTo.isEmpty());
                scanner.nextLine();
                EmployeeProject employeeProject = new EmployeeProject(empID,projectId,LocalDate.parse(dateFrom),LocalDate.parse(dateTo));

                service.addEmployee(employeeProject);

            }
            case 3 -> {
                Scanner scanner = new Scanner(System.in);
                employeeProjectList = r.read("Data.CSV");
                if (employeeProjectList.isEmpty())
                    System.out.println("There are no employees to update. Please add some!");
                else {
                    Long oldEmpID, oldProjectId;
                    String oldDateFrom, oldDateTo = null;
                    do {
                        System.out.println("Enter ID of employee you want to update: ");
                        try {
                            oldEmpID = scanner.nextLong();
                            if (oldEmpID < 0)
                                System.out.println("ID must be a positive integer. Please enter a valid ID.");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for ID.");
                            scanner.nextLine();
                            oldEmpID = Long.valueOf(-1);
                        } finally {
                            scanner.nextLine();
                        }
                    } while (oldEmpID < 0);


                    do {
                        System.out.println("Enter the projectID where the employee worked at: ");
                        try {
                            oldProjectId = scanner.nextLong();
                            if (oldProjectId < 0)
                                System.out.println("ProjectId must be a positive integer. Please enter a valid ID.");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for projectId.");
                            scanner.nextLine();
                            oldProjectId = Long.valueOf(-1);
                        } finally {
                            scanner.nextLine();
                        }
                    } while (oldProjectId < 0);

                    System.out.println("DateFrom: YYYY--MM--DD");
                    oldDateFrom = scanner.nextLine();

                    do {
                        System.out.println("DateTo: YYYY--MM--DD");
                        try {
                            oldDateTo = scanner.nextLine();
                            if (LocalDate.parse(oldDateTo).isBefore(LocalDate.parse(oldDateFrom)))
                                System.out.println("DateTo must be after DateFrom!");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid date for dateTo.");
                            scanner.nextLine();
                        } finally {
                            scanner.nextLine();
                        }
                    } while (oldDateTo.isEmpty());


                    Long empId, projectId;
                    String dateFrom, dateTo;
                        do {
                            System.out.println("EmpId: ");
                            empId = scanner.nextLong();
                            if (empId < 0)
                                System.out.println("Employee id must be higher than 0.");

                        } while (empId < 0);

                        do {
                            System.out.println("ProjectId: ");
                            projectId = scanner.nextLong();
                            if (projectId < 0)
                                System.out.println("ProjectId id must be higher than 0!");
                        } while (projectId < 0);

                        do {
                            System.out.println("DateFrom: YYYY-MM-DD");
                            dateFrom = scanner.nextLine();


                            if (dateFrom.isEmpty())
                                System.out.println("DateFrom cannot be empty!");
                        } while (dateFrom.isEmpty());

                        do {
                            System.out.println("DateTo: YYYY-MM-DD");
                            dateTo = scanner.nextLine();
                            if (dateTo.isEmpty()) System.out.println("DateTo cannot be empty. It can be NULL tho!");
                        } while (dateTo.isEmpty());
                        EmployeeProject oldEmployeeProject = new EmployeeProject(oldEmpID,oldProjectId,LocalDate.parse(oldDateFrom),LocalDate.parse(oldDateTo));
                        EmployeeProject employeeProject = new EmployeeProject(empId, projectId, LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
                        service.updateEmployee(oldEmployeeProject, employeeProject);
                }
            }
            case 4 -> {
                service.findLongestWorkingPairs();
            }
            case 5-> {
                Scanner scanner = new Scanner(System.in);
                employeeProjectList = r.read("Data.CSV");
                if (employeeProjectList.isEmpty())
                    System.out.println("There are no employees to remove. Please add some!");
                else {
                    Long empID, projectId;
                    String dateFrom, dateTo = null;
                    do {
                        System.out.println("Enter ID: ");
                        try {
                            empID = scanner.nextLong();
                            if (empID < 0)
                                System.out.println("ID must be a positive integer. Please enter a valid ID.");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for ID.");
                            scanner.nextLine();
                            empID = Long.valueOf(-1);
                        } finally {
                            scanner.nextLine();
                        }
                    } while (empID < 0);


                    do {
                        System.out.println("projectId: ");
                        try {
                            projectId = scanner.nextLong();
                            if (projectId < 0)
                                System.out.println("ProjectId must be a positive integer. Please enter a valid ID.");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for projectId.");
                            scanner.nextLine();
                            projectId = Long.valueOf(-1);
                        } finally {
                            scanner.nextLine();
                        }
                    } while (projectId < 0);

                    System.out.println("DateFrom: YYYY-MM-DD");
                    dateFrom = scanner.nextLine();

                    do {
                        System.out.println("DateTo: YYYY--MM--DD");
                        try {
                            dateTo = scanner.nextLine();
                            if (LocalDate.parse(dateTo).isBefore(LocalDate.parse(dateFrom)))
                                System.out.println("DateTo must be after DateFrom!");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid date for dateTo.");
                            scanner.nextLine();
                        } finally {
                            scanner.nextLine();
                        }
                    }while (dateTo.isEmpty());


                    EmployeeProject employeeProject = new EmployeeProject(empID, projectId, LocalDate.parse(dateFrom), LocalDate.parse(dateTo));

                    service.removeEmployee(employeeProject);
                }
            }
            case 6 ->{
                Long empId;
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.println("EmpId: ");
                    empId = scanner.nextLong();
                    if (empId<0)
                        System.out.println("Employee id must be higher than 0.");
                } while (empId<0);
                service.search(empId);

            }
            case 7 ->{
                System.out.println("Have a nice day!");
            }
        }
    }
}
