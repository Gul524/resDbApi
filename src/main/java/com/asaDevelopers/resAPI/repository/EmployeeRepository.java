package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    List<Employee> findByBranchId(Integer branchId);
    Optional<Employee> findByCnic(Integer cnic);
}
