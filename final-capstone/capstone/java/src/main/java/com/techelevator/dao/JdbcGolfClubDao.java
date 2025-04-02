package com.techelevator.dao;

import com.techelevator.ApplicationCLI;
import com.techelevator.exception.DaoException;
import com.techelevator.model.GolfClubs;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

        GolfClubs golfClub = null;
        String sql = "SELECT club_id, club_name, club_distance, club_type FROM clubs WHERE club_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, golfClubId);
            if (results.next()) {
                golfClub = mapRowToGolfClub(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return golfClub;

    }

    @Override
    public void deleteGolfClubById(int GolfClubId) {

        String sqlToDeleteClubFromDatabase = "DELETE FROM clubs WHERE club_id = ?";
        jdbcTemplate.update(sqlToDeleteClubFromDatabase, GolfClubId);

        String sqlToDeleteFromUserBag = "DELETE FROM user_bags WHERE club_id = ?;";
        jdbcTemplate.update(sqlToDeleteFromUserBag, GolfClubId);

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

    private GolfClubs mapRowToGolfClub(SqlRowSet rs) {
        GolfClubs club = new GolfClubs();
        club.setClubId(rs.getInt("club_id"));
        club.setClubName(rs.getString("club_name"));
        club.setClubDistance(rs.getInt("club_distance"));
        club.setClubType(rs.getString("club_type"));
        return club;
    }

    }



