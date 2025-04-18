package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
    List<Size> findByBranchId(Integer branchId);
}
