package com.example.jdbc_user.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
 @GetMapping
    public String home(){
        return "hello world";
    }
    @GetMapping("/admin")
    public String Admin() {
        return "hello admin";
    
    }
}
