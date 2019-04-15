package com.daugherty.dashboardbackend.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class AdminDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AdminDAO.class);

    AdminConfiguration getConfiguration(String tvIdentifier) {
        //TODO: Connect to Postgres and create and adminConfiguration from the returned data
        AdminConfiguration adminConfiguration = new AdminConfiguration();
        adminConfiguration.setTvIdentifier(tvIdentifier);
        getEntity(adminConfiguration);
        return adminConfiguration;
    }

    String saveConfiguration(AdminConfiguration adminConfiguration) {
        return createConfiguration(adminConfiguration);
    }

    private boolean getEntity(AdminConfiguration adminConfiguration) {
        //TODO: Connect to Postgres and check to see if the identifier exists
        return adminConfiguration.getTvIdentifier().equals("atl-dev");
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

    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
}
