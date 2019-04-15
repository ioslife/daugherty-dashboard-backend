package com.daugherty.dashboardbackend.admin

import spock.lang.Specification

class AdminControllerSpec extends Specification {

    def "Ensure admin panel greeting is correct"() {
        given: "An adminController"
        AdminController adminController = new AdminController()

        expect: "The default behavior of the admin panel greeting"
        adminController.adminPanelGreeting() == "Welcome to the Daugherty Dashboard admin panel!"
    }

    def "Get config returns data as expected"() {

    }
}
