package com.daugherty.dashboardbackend.admin;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminBO {

    private AdminDAO adminDAO;

    @Autowired
    public AdminBO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    String getTVConfiguration(String tvIdentifier) {
        Gson gson = new Gson();
        AdminConfiguration adminConfiguration = adminDAO.getConfiguration(tvIdentifier);
        return gson.toJson(adminConfiguration);
    }

    String updateTVConfiguration(AdminConfiguration adminConfiguration) {
        return adminDAO.saveConfiguration(adminConfiguration);
    }
}
