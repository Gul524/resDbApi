package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Category;
import com.asadevelopers.resDbApi.dbModel.InventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryLogRepository extends JpaRepository<InventoryLog, Integer> {
    List<InventoryLog> findByBranchId(Integer branchId);
}
