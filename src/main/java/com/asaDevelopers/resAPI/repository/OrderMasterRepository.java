package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
    List<OrderMaster> findByBranchId(Integer branchId);
    List<OrderMaster> findBycustomerPhone(Integer branchId);
}
