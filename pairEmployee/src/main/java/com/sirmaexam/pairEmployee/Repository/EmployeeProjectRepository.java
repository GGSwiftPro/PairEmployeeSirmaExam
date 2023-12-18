package com.sirmaexam.pairEmployee.Repository;

import com.sirmaexam.pairEmployee.Model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeProjectRepository extends CrudRepository<EmployeeProject, Long> {

       List<EmployeeProject> findAllByEmpId(Long EmpId);

    //List<EmployeeProject> findByEmpIDAndProjectIDOrderByDateFrom(Long empID, Long projectID);
}