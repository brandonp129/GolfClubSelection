package com.techelevator.dao;


import com.techelevator.model.GolfBags;
import com.techelevator.model.GolfClubs;

import java.util.List;

public interface GolfBagDao {

    //need to come back to add parameter
    GolfBags addGolfBagToDataBaseAndUserList(int userId, GolfBags golfBag);

    //need to come back to add parameters
    List<GolfClubs> getListOfUserGolfBags();

    void deleteGolfBagByBagId(int golfBagId);
}
