package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Category;
import com.asadevelopers.resDbApi.dbModel.OrderDetail;
import com.asadevelopers.resDbApi.dbModel.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByBranchId(Integer branchId);
}
