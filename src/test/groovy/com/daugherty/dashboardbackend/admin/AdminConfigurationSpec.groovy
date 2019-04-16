package com.daugherty.dashboardbackend.admin

import spock.lang.Specification
import spock.lang.Unroll

class AdminConfigurationSpec extends Specification {

    def "Ensure empty admin configurations return empty"() {
        given: "An empty adminConfiguration"
        AdminConfiguration adminConfiguration = new AdminConfiguration()

        expect: "No Data has been added to the configuration"
        adminConfiguration.banner == ""
        adminConfiguration.sidebar == ""
        adminConfiguration.tvIdentifier == ""
        adminConfiguration.videoPlaylist == ""
    }

    def "Ensure no data validations are occurring in the POJO for the TV configuration"() {
        given: "A populated adminConfiguration"
        AdminConfiguration adminConfiguration = new AdminConfiguration(tvIdentifier, videoPlaylist, banner, sidebar)

        expect: "The adminConfiguration is populated without modification to the values"
        adminConfiguration.banner == banner
        adminConfiguration.sidebar == sidebar
        adminConfiguration.tvIdentifier == tvIdentifier
        adminConfiguration.videoPlaylist == videoPlaylist

        where:
        banner   | sidebar   | tvIdentifier | videoPlaylist
        ""       | ""        | ""           | ""
        "banner" | "sidebar" | "tvID"       | "videoPlaylist"
    }

    @Unroll("Ensure getters and setters are working as expected")
    def "Ensure getters and setters are working as expected"() {
        given: "An empty adminConfiguration"
        AdminConfiguration adminConfiguration = new AdminConfiguration()

        when: "The adminConfiguration is populated with values"
        adminConfiguration.banner = banner
        adminConfiguration.sidebar = sidebar
        adminConfiguration.tvIdentifier = tvIdentifier
        adminConfiguration.videoPlaylist = videoPlaylist

        then: "The adminConfiguration does not modify values that are being added."
        adminConfiguration.banner == banner
        adminConfiguration.sidebar == sidebar
        adminConfiguration.tvIdentifier == tvIdentifier
        adminConfiguration.videoPlaylist == videoPlaylist

        where:
        banner   | sidebar   | tvIdentifier | videoPlaylist
        ""       | ""        | ""           | ""
        "banner" | "sidebar" | "tvID"       | "videoPlaylist"
    }
}
