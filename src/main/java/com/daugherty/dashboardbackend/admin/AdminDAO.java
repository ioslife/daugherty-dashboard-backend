package com.daugherty.dashboardbackend.admin;

import org.springframework.stereotype.Component;

@Component
public class AdminDAO {

    public AdminConfiguration getConfiguration(String tvIdentifier) {
        return new AdminConfiguration(tvIdentifier, "", "", "");
    }

    public String saveConfiguration(AdminConfiguration adminConfiguration) {
        return adminConfiguration.getTvIdentifier().equals("atl-dev") ?
                updateConfiguration(adminConfiguration) :
                createConfiguration(adminConfiguration);
    }

    private String updateConfiguration(AdminConfiguration adminConfiguration) {
        return "Updated " + adminConfiguration.getTvIdentifier();
    }

    private String createConfiguration(AdminConfiguration adminConfiguration) {
        return "Created configuration for " + adminConfiguration.getTvIdentifier();
    }
}
