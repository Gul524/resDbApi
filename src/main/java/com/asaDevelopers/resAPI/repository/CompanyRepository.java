package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
