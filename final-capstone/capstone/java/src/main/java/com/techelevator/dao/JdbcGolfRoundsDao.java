package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.GolfRounds;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcGolfRoundsDao implements GolfRoundsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGolfRoundsDao( JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GolfRounds getGolfRoundsById(int golfRoundId) {

        GolfRounds golfRound = null;
        String sql = "SELECT round_id, user_id, date_played, course_name, total_score, notes FROM rounds WHERE round_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, golfRoundId);
            if (results.next()) {
                golfRound = mapRowToGolfRound(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return golfRound;
    }

    @Override
    public GolfRounds addGolfRoundToDataBaseAndUser (int userId, GolfRounds round) {

        String sqlToAddRoundToDatabase = "INSERT INTO rounds (user_id, date_played, total_score, notes)"
                + "VALUES (?, ?, ?, ?) returning round_id;";

        int newRoundId = jdbcTemplate.queryForObject(sqlToAddRoundToDatabase, int.class, round.getUserId(),
                round.getDatePlayed(), round.getTotalScore(), round.getNotes());
        round.setRoundId(newRoundId);

        String sqlToAddRoundToUser = "INSERT INTO round_players (user_id, round_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlToAddRoundToUser, userId, round.getRoundId());

        return round;
    }



    private GolfRounds mapRowToGolfRound(SqlRowSet results) {
        GolfRounds round = new GolfRounds();
        round.setRoundId(results.getInt("round_id"));
        round.setUserId(results.getInt("user_id"));
        round.setDatePlayed(results.getDate("date_played").toLocalDate());
        round.setCourseName(results.getString("course_name"));
        round.setTotalScore(results.getInt("total_score"));
        round.setNotes(results.getString("notes"));
        return round;
    }
}
