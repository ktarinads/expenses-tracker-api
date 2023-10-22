package com.tutoriais.expensestrackerapi.resources;

import com.tutoriais.expensestrackerapi.domain.Category;
import com.tutoriais.expensestrackerapi.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String getAllCategories(HttpServletRequest request){
        int userID = (Integer) request.getAttribute("userID");
        return "Authenticated userID "+userID;
    }
    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap){
        int userId = (Integer) request.getAttribute("userId");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categoryService.addCategory(userId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
