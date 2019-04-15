package com.daugherty.dashboardbackend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class AdminController {

    private AdminBO adminBO;

    @Autowired
    public AdminController(AdminBO adminBO) {
        this.adminBO = adminBO;
    }

    @GetMapping("/api/v1/admin/")
    public String adminPanelGreeting() {
        return "Welcome to the Daugherty Dashboard admin panel!";
    }

    @GetMapping(value = "/api/v1/admin/getConfig", produces = "application/json")
    public ResponseEntity<String> getConfig(@Valid @NotNull String tvIdentifier) {
        return new ResponseEntity<>(adminBO.getTVConfiguration(tvIdentifier), HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/admin/updateConfig/", consumes = "application/json")
    public ResponseEntity<String> updateConfig(@RequestBody AdminConfiguration adminConfiguration) {
        return new ResponseEntity<>(adminBO.updateTVConfiguration(adminConfiguration), HttpStatus.OK);
    }

}
