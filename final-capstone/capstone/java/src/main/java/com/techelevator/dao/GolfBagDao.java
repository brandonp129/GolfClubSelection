package com.techelevator.dao;


import java.util.List;

public interface GolfBagDao {

    //need to come back to add parameters
    void addGolfBagToDataBaseAndUserList();

    //need to come back to add parameters
    List<Integer> getListOfUserGolfBags();

    void deleteGolfBagByBagId(int golfBagId);
}
