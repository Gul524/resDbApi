package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.*;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    @Autowired private BranchRepository repository;

    public ResponseEntity<ApiResponse<List<Branch>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<Branch>>> getById(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<Branch>> save(Iterable<Branch> entity) {
        try {
            repository.saveAll(entity);
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , null));
        } catch (Exception e) {
           return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<String>> delete(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(true , "Deleted successfully" , "" , null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<List<Branch>>> getAllByBranchId(Integer id) {
        try {
             ResponseEntity.ok(repository.findById(id));
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }

    public ResponseEntity<ApiResponse<String>> deleteAll(Integer id) {
        try {
            repository.deleteAll();
            return ResponseEntity.ok(new ApiResponse<>(true , "Deleted successfully" , "" , null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }
}
