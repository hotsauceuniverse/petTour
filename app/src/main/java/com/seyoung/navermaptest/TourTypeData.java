package com.seyoung.navermaptest;

import java.io.Serializable;

public class TourTypeData implements Serializable {
    private String title;
    private String tourType;
    private String address;
    private String mapX;
    private String mapY;

    public TourTypeData(String title, String tourType, String address, String mapX, String mapY) {
        this.title = title;
        this.tourType = tourType;
        this.address = address;
        this.mapX = mapX;
        this.mapY = mapY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMapX() {
        return mapX;
    }

    public void setMapX(String mapX) {
        this.mapX = mapX;
    }

    public String getMapY() {
        return mapY;
    }

    public void setMapY(String mapY) {
        this.mapY = mapY;
    }
}
