package com.daugherty.dashboardbackend.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AdminDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AdminDAO.class);

    AdminConfiguration getConfiguration(String tvIdentifier) {
        //TODO: Connect to Postgres and create and adminConfiguration from the returned data
        AdminConfiguration adminConfiguration = new AdminConfiguration();
        adminConfiguration.setTvIdentifier(tvIdentifier);
        if (entityExists(tvIdentifier)) {
            adminConfiguration.setBanner("banner");
            adminConfiguration.setSidebar("sidebar");
            adminConfiguration.setVideoPlaylist("videoList");
        }
        return adminConfiguration;
    }

    String saveConfiguration(AdminConfiguration adminConfiguration) {
        return entityExists(adminConfiguration.getTvIdentifier())?
                updateConfiguration(adminConfiguration) :
                createConfiguration(adminConfiguration);
    }

    private boolean entityExists(String tvIdentifier) {
        //TODO: Connect to Postgres and check to see if the identifier exists
        return tvIdentifier.equals("atl-dev");
    }

    private String updateConfiguration(AdminConfiguration adminConfiguration) {
        //TODO: Connect to Postgres and update an existing configuration
        LOG.info("Updating configuration for {}", adminConfiguration.getTvIdentifier());
        return "Updated " + adminConfiguration.getTvIdentifier();
    }

    private String createConfiguration(AdminConfiguration adminConfiguration) {
        //TODO: Connect to Postgres and insert a new configuration
        LOG.info("Created configuration for {}", adminConfiguration.getTvIdentifier());
        return "Created configuration for " + adminConfiguration.getTvIdentifier();
    }
}
