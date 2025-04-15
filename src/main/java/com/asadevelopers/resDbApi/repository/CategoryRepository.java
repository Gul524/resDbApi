package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByBranchId(Integer branchId);
}
