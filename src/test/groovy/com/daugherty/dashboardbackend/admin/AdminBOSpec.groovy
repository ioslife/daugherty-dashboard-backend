package com.daugherty.dashboardbackend.admin

import spock.lang.Specification

class AdminBOSpec extends Specification{

    AdminBO generateNewAdminBO() {
        AdminBO adminBO = new AdminBO()
        adminBO.adminDAO = Mock(AdminDAO)
        adminBO
    }

    def "Ensure the adminBO successfully passes the request through to the DAO"() {

    }
}
