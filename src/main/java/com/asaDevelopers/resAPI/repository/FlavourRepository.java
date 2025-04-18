package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Flavour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlavourRepository extends JpaRepository<Flavour, Integer> {
    List<Flavour> findByBranchId(Integer branchId);

}
