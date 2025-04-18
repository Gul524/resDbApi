package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Customer;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired private CustomerRepository repository;

    public ResponseEntity<ApiResponse<List<Customer>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<Customer>>> getById(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", Optional.empty()));
        }
    }

    public ResponseEntity<ApiResponse<Customer>> save(Iterable<Customer> entity) {
        try {
            repository.saveAll(entity);
            return ResponseEntity.ok(new ApiResponse<>(true, "Saved successfully", "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<String>> delete(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Deleted successfully", "", "Deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<Customer>>> getAllByPhone(Integer phone) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findByPhone(phone)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Customer>> updatePoints(Integer phone , Integer points , Integer totalPoints) {
        try {
             Optional<Customer> customers =  repository.findByPhone(phone);
             if(customers.isPresent()) {
                Customer c = customers.get();
                c.setAvailablePoints(points);
                c.setTotalPoints(totalPoints);
                repository.save(c);
                 return ResponseEntity.ok(new ApiResponse<>(true , "Points Updated Successfully" , "" , null));
             }
            return ResponseEntity.ok(new ApiResponse<>(true , "Customer does not exist against this number" , "" , null));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse<>(true , e.getMessage() ,  e.getCause() != null ? e.getCause().toString() : "" , null));
        }

    }

    public ResponseEntity<ApiResponse<Customer>> updateName(Integer phone , String name) {
        try {
            Optional<Customer> customers =  repository.findByPhone(phone);
            if(customers.isPresent()) {
                Customer c = customers.get();
                c.setName(name);
                repository.save(c);
                return ResponseEntity.ok(new ApiResponse<>(true , "Customer Name Updated Successfully" , "" , null));
            }
            return ResponseEntity.ok(new ApiResponse<>(true , "Customer does not exist against this number" , "" , null));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse<>(true , e.getMessage() ,  e.getCause() != null ? e.getCause().toString() : "" , null));
        }

    }
}
