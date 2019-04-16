package com.daugherty.dashboardbackend.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminConfiguration {

    @Id
    private String tvIdentifier;
    private String videoPlaylist;
    private String banner;
    private String sidebar;

    public AdminConfiguration() {
        tvIdentifier = "";
        videoPlaylist = "";
        banner = "";
        sidebar = "";
    }

    public AdminConfiguration(String tvIdentifier) {
        this.tvIdentifier = tvIdentifier;
        videoPlaylist = "";
        banner = "";
        sidebar = "";
    }

    public AdminConfiguration(String tvIdentifier, String videoPlaylist, String banner, String sidebar) {
        this.tvIdentifier = tvIdentifier;
        this.videoPlaylist = videoPlaylist;
        this.banner = banner;
        this.sidebar = sidebar;
    }

    public String getTvIdentifier() {
        return tvIdentifier;
    }

    public void setTvIdentifier(String tvIdentifier) {
        this.tvIdentifier = tvIdentifier;
    }

    public String getVideoPlaylist() {
        return videoPlaylist;
    }

    public void setVideoPlaylist(String videoPlaylist) {
        this.videoPlaylist = videoPlaylist;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSidebar() {
        return sidebar;
    }

    public void setSidebar(String sidebar) {
        this.sidebar = sidebar;
    }

}
