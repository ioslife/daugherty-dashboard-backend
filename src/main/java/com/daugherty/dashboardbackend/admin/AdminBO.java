package com.daugherty.dashboardbackend.admin;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminBO {

    private AdminDAO adminDAO;

    @Autowired
    public AdminBO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    String getTVConfiguration(String tvIdentifier) {
        Gson gson = new Gson();
        Optional<AdminConfiguration> adminConfiguration = adminDAO.findById(tvIdentifier);
        if (!adminConfiguration.isPresent()) {
            return gson.toJson(new AdminConfiguration(tvIdentifier));
        }
        return gson.toJson(adminConfiguration.get());
    }

    String updateTVConfiguration(AdminConfiguration adminConfiguration) {
        adminDAO.save(adminConfiguration);
        return "Admin Configuration saved successfully for tv " + adminConfiguration.getTvIdentifier();
    }
}
