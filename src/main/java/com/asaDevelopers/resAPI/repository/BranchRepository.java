package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    List<Branch> findAllByCompanyId(Integer integer);
}
