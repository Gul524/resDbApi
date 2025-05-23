package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Branch;
import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired private CategoryRepository repository;

    public ResponseEntity<ApiResponse<List<Category>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<Category>>> getById(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", "", repository.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", Optional.empty()));
        }
    }

    public ResponseEntity<ApiResponse<Category>> save(Iterable<Category> entity) {
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

    public ResponseEntity<ApiResponse<String>> update(Integer id,String name) {
        try {
            Category category = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

            category.setCategoryName(name);

            repository.save(category);

            return ResponseEntity.ok(new ApiResponse<>(true, "Category updated successfully", null, null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false, e.getMessage(), null, null));
        } catch (Exception e) {
            // Handle unexpected errors
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>(false, "Failed to update category", e.getMessage(), null));
        }
    }

}
