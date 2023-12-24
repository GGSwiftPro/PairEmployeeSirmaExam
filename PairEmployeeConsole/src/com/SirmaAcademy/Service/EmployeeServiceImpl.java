package com.SirmaAcademy.Service;

import com.SirmaAcademy.Client.EmployeeProject;
import com.SirmaAcademy.ReaderWriter.CustomReader;
import com.SirmaAcademy.ReaderWriter.CustomWriter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    CustomReader r;
    CustomWriter wr;
    List<EmployeeProject> temp = new ArrayList<>();
    List<EmployeeProject> employeesFromFile;

    public EmployeeServiceImpl(CustomReader fileReader, CustomWriter fileWriter) {
        this.r = fileReader;
        this.wr = fileWriter;
    }
    public void viewEmployees() {
        employeesFromFile = (List<EmployeeProject>) r.read("Data.CSV");
        if (employeesFromFile != null && !employeesFromFile.isEmpty()) {
            System.out.println("List of Employees:");
            for (var employee : employeesFromFile) {
                System.out.println(employee.Information());
            }
        } else {
            System.out.println("No employees found.");
        }
    }

    @Override
    public void addEmployee(EmployeeProject employeeProject) {
        temp.add(employeeProject);
        wr.write( temp, "Data.CSV");
    }

    public void updateEmployee(EmployeeProject oldEmployeeProject,EmployeeProject employeeProject)
    {
        employeesFromFile = (List<EmployeeProject>) r.read("Data.CSV");
        for (var x : employeesFromFile)
            if(Objects.equals(x.getEmpId(), oldEmployeeProject.getEmpId())
            && Objects.equals(x.getProjectId(), oldEmployeeProject.getProjectId())
                    && x.getDateFrom().equals(oldEmployeeProject.getDateFrom())
                    && x.getDateTo().equals(oldEmployeeProject.getDateTo()))
            {
                employeesFromFile.remove(oldEmployeeProject.getEmpId());
                x.setEmpId(employeeProject.getEmpId());
                x.setProjectId(employeeProject.getProjectId());
                x.setDateFrom(employeeProject.getDateFrom());
                x.setDateTo(employeeProject.getDateTo());
                employeesFromFile.add(x);
                wr.write(employeesFromFile,"Data.CSV");
            }
    }
    public void search(Long empId)
    {
        boolean found = false;
        employeesFromFile = (List<EmployeeProject>) r.read("Data.CSV");
        for (var x : employeesFromFile)
            if(Objects.equals(x.getEmpId(), empId))
            {
                found=true;
                System.out.println( x.Information());
            }
        if(!found) System.out.println("No such employee found!");

    }
    public void removeEmployee(EmployeeProject employeeProject)
    {
        employeesFromFile = r.read("Data.CSV");
        Iterator<EmployeeProject> iterator = employeesFromFile.iterator();
        boolean deleted = false;
        if(employeesFromFile.isEmpty()) System.out.println("There are no employees to remove. Please add some!");
        while (iterator.hasNext()) {
            EmployeeProject curr = iterator.next();
            if (Objects.equals(employeeProject.getEmpId(), curr.getEmpId())
                    && Objects.equals(employeeProject.getProjectId(), curr.getProjectId())
                    && employeeProject.getDateFrom().equals(curr.getDateFrom())
                    && employeeProject.getDateTo().equals(curr.getDateTo()))
             {
                 iterator.remove();
                 deleted = true;
             }
        }
        if (!deleted) System.out.println("Didn't find client with that id!");
        wr.write(employeesFromFile, "Data.CSV");
    }

    public void findLongestWorkingPairs() {

        Map<Long, List<EmployeeProject>> employeesByProjectId = new HashMap<>();
        employeesFromFile = (List<EmployeeProject>) r.read("Data.CSV");
        //Long empId1,empId2,period;
        Long empWork = 0L;
        Long maxEmpWork = 0L;
        EmployeeProject pairEmp1 = null;
        EmployeeProject pairEmp2 = null;
        employeesByProjectId =  employeesFromFile.stream()
                .collect(Collectors.toMap(
                        EmployeeProject::getProjectId,
                        x -> {
                            ArrayList<EmployeeProject> result =  new ArrayList<EmployeeProject>();
                            result.add(x);
                            return result;
                        },
                        (a,b) -> {
                            a.addAll(b);
                            return a;
                        }));
        for (Long projectId : employeesByProjectId.keySet() ) {
            List<EmployeeProject> empployeesList = employeesByProjectId.get(projectId);
            for(int i =0;i<empployeesList.size()-1;i++)
            {
                for(int j=i+1;j<empployeesList.size();j++)
                {
                    EmployeeProject emp1 = empployeesList.get(i);
                    EmployeeProject emp2 = empployeesList.get(j);


                    //Проверяваме интервала в който работят заедно зада знаем с between кой интервал да използваме
                    if(emp1.getDateFrom().isBefore(emp2.getDateFrom())
                            && emp1.getDateToOrToday().isAfter(emp2.getDateFrom())
                            && emp1.getDateToOrToday().isBefore(emp2.getDateToOrToday()))

                        empWork = ChronoUnit.DAYS.between(emp2.getDateFrom(),emp1.getDateToOrToday());
                    else
                    if((emp2.getDateFrom().isAfter(emp1.getDateFrom()) && emp2.getDateToOrToday().isBefore(emp1.getDateToOrToday())))

                        empWork = ChronoUnit.DAYS.between(emp2.getDateFrom(),emp2.getDateToOrToday());
                    else

                    if((emp2.getDateFrom().isBefore(emp1.getDateFrom())
                            && emp2.getDateToOrToday().isBefore(emp1.getDateToOrToday()))
                            &&  emp1.getDateFrom().isBefore(emp2.getDateToOrToday()))

                        empWork = ChronoUnit.DAYS.between(emp1.getDateFrom(),emp2.getDateToOrToday());
                    else
                    if(emp1.getDateFrom().isAfter(emp2.getDateFrom())
                            && emp1.getDateFrom().isBefore(emp2.getDateToOrToday())
                            && emp1.getDateToOrToday().isAfter(emp2.getDateFrom())
                            && emp1.getDateToOrToday().isBefore(emp2.getDateToOrToday()))

                        empWork= ChronoUnit.DAYS.between(emp1.getDateFrom(),emp1.getDateToOrToday());
                    else
                    if(emp1.getDateFrom().equals(emp2.getDateFrom())
                        && emp1.getDateToOrToday().isBefore(emp2.getDateToOrToday()))

                        empWork=ChronoUnit.DAYS.between(emp1.getDateFrom(),emp1.getDateToOrToday());
                    else
                    if(emp1.getDateFrom().equals(emp2.getDateFrom())
                            && emp2.getDateToOrToday().isBefore(emp1.getDateToOrToday()))

                        empWork=ChronoUnit.DAYS.between(emp1.getDateFrom(),emp2.getDateToOrToday());
                    else
                    if(emp1.getDateFrom().equals(emp2.getDateFrom())
                            && emp1.getDateToOrToday().equals(emp2.getDateToOrToday()))

                        empWork=ChronoUnit.DAYS.between(emp1.getDateFrom(),emp1.getDateToOrToday());
                    empWork++;   //Between Взима до дата и затова е +1 за да е точна бройката

                if(empWork>maxEmpWork)
                {
                    maxEmpWork=empWork;
                    pairEmp1=emp1;

                    pairEmp2=emp2;}
                }
            }

        }
        System.out.print("Employee with IDs ");
        System.out.print(pairEmp1.getEmpId()+ " and ");
        System.out.print(pairEmp2.getEmpId() + " have worked for total of ");
        System.out.print(maxEmpWork + " days on project with id: ");
        System.out.println(pairEmp1.getProjectId() + "!");
    }
}
