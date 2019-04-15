package com.daugherty.dashboardbackend.admin;

import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController()
public class AdminController {

    @GetMapping("/api/v1/admin/")
    public String adminPanelGreeting() {
        return "Welcome to the Daugherty Dashboard admin panel!";
    }

    @GetMapping("/api/v1/admin/getConfig")
    public ResponseEntity<String> getConfig(@Valid @NotNull String tvIdentifier) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tvIdentifier", tvIdentifier);
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/admin/updateConfig/")
    public ResponseEntity<String> updateConfig() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
