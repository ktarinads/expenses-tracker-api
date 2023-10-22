package com.tutoriais.expensestrackerapi.resources;

import com.tutoriais.expensestrackerapi.Constants;
import com.tutoriais.expensestrackerapi.domain.User;
import com.tutoriais.expensestrackerapi.service.UserService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> usermap){
        String firstName = (String) usermap.get("firstName");
        String lastName = (String) usermap.get("lastName");
        String email = (String) usermap.get("email");
        String pass = (String) usermap.get("pass");
        User user = userService.registerUser(firstName, lastName, email, pass);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user){
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userID", user.getUserID())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}
