package com.techelevator.dao;

import com.techelevator.model.GolfClubs;

import java.util.List;

public interface GolfClubDao {

    //need to come back to add parameters

    //need to come back to add parameters
    List<Integer> getListOfGolfClubsInGolfBag();

    GolfClubs getGolfClubById(int golfClubId);

    void deleteGolfClubById(int GolfClubId);

    GolfClubs addGolfClubToDatabaseAndGolfBag(int bagId, GolfClubs golfClub);
}
