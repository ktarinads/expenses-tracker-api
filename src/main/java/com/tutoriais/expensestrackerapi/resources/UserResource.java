package com.tutoriais.expensestrackerapi.resources;

import com.tutoriais.expensestrackerapi.domain.User;
import com.tutoriais.expensestrackerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> usermap){
        String email = (String) usermap.get("email");
        String password = (String) usermap.get("password");
        User user = userService.validateUser(email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "logged in sucessfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> usermap){
        String firstName = (String) usermap.get("firstName");
        String lastName = (String) usermap.get("lastName");
        String email = (String) usermap.get("email");
        String pass = (String) usermap.get("pass");
        User user = userService.registerUser(firstName, lastName, email, pass);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
