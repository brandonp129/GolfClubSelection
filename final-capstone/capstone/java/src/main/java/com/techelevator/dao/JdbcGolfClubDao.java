package com.techelevator.dao;

import com.techelevator.ApplicationCLI;
import com.techelevator.model.GolfClubs;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGolfClubDao implements GolfClubDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGolfClubDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Integer> getListOfGolfClubsInGolfBag() {
        return null;
    }

    @Override
    public GolfClubs getGolfClubById(int golfClubId) {
        return null;
    }

    @Override
    public void deleteGolfClubById(int GolfClubId) {

    }

    @Override
    public GolfClubs addGolfClubToDatabaseAndGolfBag(int bagId, GolfClubs golfClub) {

        String sqlToAddClubToDatabase = "INSERT INTO clubs (bag_id, club_name, club_distance, club_type)" +
                " VALUES (?, ?, ?, ?, ?) returning club_id;";
        int newClubId = jdbcTemplate.queryForObject(sqlToAddClubToDatabase, int.class, golfClub.getClubName(),
                golfClub.getClubDistance(), golfClub.getClubType());
        golfClub.setClubId(newClubId);

        String sqlToAddClubToGolfBag = "INSERT INTO bag_clubs (bag_id, club_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlToAddClubToGolfBag, bagId, golfClub.getClubId());

        return golfClub;
    }

    }



