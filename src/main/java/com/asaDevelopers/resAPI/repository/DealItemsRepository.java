package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.DealItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealItemsRepository extends JpaRepository<DealItems, Integer> {
}
