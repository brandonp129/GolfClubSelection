package com.techelevator.dao;


import com.techelevator.model.GolfBags;

import java.util.List;

public interface GolfBagDao {

    //need to come back to add parameter
    GolfBags addGolfBagToDataBaseAndUserList(int userId, GolfBags golfBag);

    //need to come back to add parameters
    List<Integer> getListOfUserGolfBags();

    void deleteGolfBagByBagId(int golfBagId);
}
