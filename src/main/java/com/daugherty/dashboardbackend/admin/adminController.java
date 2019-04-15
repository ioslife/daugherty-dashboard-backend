package com.daugherty.dashboardbackend.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class adminController {

    @GetMapping("/")
    public String helloWorld() {
        return "Welcome to the Daugherty Dashboard admin panel!";
    }

}
