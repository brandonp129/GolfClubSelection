package com.techelevator.model;

public class GolfClubs {

    private int clubId;

    private int bagId;

    private int clubDistance;

    private String clubType;

    private String clubName;

    public GolfClubs() {

    }


    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getClubDistance() {
        return clubDistance;
    }

    public void setClubDistance(int clubDistance) {
        this.clubDistance = clubDistance;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) {
        this.clubType = clubType;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
