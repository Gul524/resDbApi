package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch findByBranchId(Integer branchId);
}
