package com.sirmaexam.pairEmployee.Repository;

import com.sirmaexam.pairEmployee.Model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

    //List<EmployeeProject> findByEmpIDAndProjectIDOrderByDateFrom(Long empID, Long projectID);
}