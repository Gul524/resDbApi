package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.OrderMaster;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.OrderMasterRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMasterService {
    @Autowired private OrderMasterRepository repository;

    public ResponseEntity<ApiResponse<List<OrderMaster>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<OrderMaster>>> getById(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", Optional.empty()));
        }
    }

    public ResponseEntity<ApiResponse<String>> save(Iterable<OrderMaster> entity) {
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

    public ResponseEntity<ApiResponse<String>> status(Integer id , String status) {
        try {
            Optional<OrderMaster> oom = repository.findById(id);
            if(oom.isPresent()){
                OrderMaster om = oom.get();
                om.setStatus(status);
                repository.save(om);
            }

            return ResponseEntity.ok(new ApiResponse<>(true, "Status Updated successfully", "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }



    public ResponseEntity<ApiResponse<List<OrderMaster>>> getAllByBranchId(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" ,repository.findByBranchId(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<List<OrderMaster>>> getAllByPhone(Integer phone) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" ,repository.findBycustomerPhone(phone)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }
}
