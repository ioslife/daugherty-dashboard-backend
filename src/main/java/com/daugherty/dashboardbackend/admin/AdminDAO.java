package com.daugherty.dashboardbackend.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminDAO extends CrudRepository<AdminConfiguration, String> {

}
