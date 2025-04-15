package com.asadevelopers.resDbApi.repository;

import com.asadevelopers.resDbApi.dbModel.Customer;
import com.asadevelopers.resDbApi.dbModel.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Optional<Customer> findByPhone(Integer phone);
}
