package com.techelevator.dao;

import com.techelevator.model.GolfBags;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JdbcGolfBagDao implements GolfBagDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcGolfBagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public GolfBags addGolfBagToDataBaseAndUserList(int userId, GolfBags golfBag) {
        String sqlToAddBagToDatabase = "INSERT INTO bags (user_Id, bag_name) VALUES (?, ?) returning bag_id;";
        int newBagId = jdbcTemplate.queryForObject(sqlToAddBagToDatabase, int.class, golfBag.getUserId(), golfBag.getName());
        golfBag.setBagId(newBagId);

        String sqlToAddBagToUserList = "INSERT INTO user_bags (user_id, bag_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlToAddBagToUserList, userId, golfBag.getgolfBagId());

        return golfBag;
    }

    @Override
    public List<Integer> getListOfUserGolfBags() {
        return null;
    }

    @Override
    public void deleteGolfBagByBagId(int golfBagId) {
        String sqlToDeleteBagToDatabase = "DELETE FROM bags WHERE bag_id = ?";
        jdbcTemplate.update(sqlToDeleteBagToDatabase, golfBagId);

        String sqlToDeleteFromUserBag = "DELETE FROM user_bags WHERE bag_id = ?;";
        jdbcTemplate.update(sqlToDeleteFromUserBag, golfBagId);


    }
}
