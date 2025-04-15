package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Category;
import com.asadevelopers.resDbApi.dbModel.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByBranchId(Integer branchId);
}
