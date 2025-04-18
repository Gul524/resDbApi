package com.asaDevelopers.resAPI.repository;

import com.asaDevelopers.resAPI.dbModel.Deals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository  extends JpaRepository<Deals, Integer> {

}
