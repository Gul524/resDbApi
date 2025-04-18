package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Flavour;
import com.asaDevelopers.resAPI.dbModel.TableEntity;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.FlavourRepository;
import com.asaDevelopers.resAPI.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlavourService {
    @Autowired private FlavourRepository repository;

    public ResponseEntity<ApiResponse<List<Flavour>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Flavour>> getById(Integer id) {
        try {
            Optional<Flavour> table = repository.findById(id);
            if (table.isPresent()) {
                return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", table.get()));
            } else {
                return ResponseEntity.status(404).body(new ApiResponse<>(false, "TableEntity not found", "", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Flavour>> save(Iterable<Flavour> entity) {
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


}
