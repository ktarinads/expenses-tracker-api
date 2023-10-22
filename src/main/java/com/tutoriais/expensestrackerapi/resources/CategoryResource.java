package com.tutoriais.expensestrackerapi.resources;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
    @GetMapping("")
    public String getAllCategories(HttpServletRequest request){
        int userID = (Integer) request.getAttribute("userID");
        return "Authenticated userID "+userID;
    }
}
