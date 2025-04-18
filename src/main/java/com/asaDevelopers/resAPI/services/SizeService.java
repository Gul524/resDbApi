package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Size;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Autowired private SizeRepository repository;

    public ResponseEntity<ApiResponse<List<Size>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Size>> getById(Integer id) {
        try {
            Optional<Size> size = repository.findById(id);
            if (size.isPresent()) {
                return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", size.get()));
            } else {
                return ResponseEntity.status(404).body(new ApiResponse<>(false, "Size not found", "", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Size>> save(Iterable<Size> entity) {
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
            return ResponseEntity.ok(new ApiResponse<>(true, "Deleted successfully", "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<List<Size>>> getAllByBranchId(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" ,repository.findByBranchId(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
        }
    }
}
