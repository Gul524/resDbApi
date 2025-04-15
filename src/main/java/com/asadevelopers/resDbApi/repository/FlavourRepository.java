package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Category;
import com.asadevelopers.resDbApi.dbModel.Flavour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlavourRepository extends JpaRepository<Flavour, Integer> {
    List<Flavour> findByBranchId(Integer branchId);

}
