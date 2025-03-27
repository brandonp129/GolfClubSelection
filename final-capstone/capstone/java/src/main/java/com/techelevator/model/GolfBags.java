package com.techelevator.model;

import java.util.List;

public class GolfBags {

    private int bagId;

    private int userId;

    private List<GolfClubs> golfClubs;

    private String name;


    public GolfBags() {

    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List getGolfClubs() {
        return golfClubs;
    }

    public void setGolfClubs(List golfClubs) {
        this.golfClubs = golfClubs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getgolfBagId() {

        return bagId;
    }
}
