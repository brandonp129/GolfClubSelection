package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.GolfClubs;
import com.techelevator.model.GolfCourses;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcGolfCoursesDao implements GolfCoursesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGolfCoursesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GolfCourses> getListOfGolfCourses() {
        return null;
    }

    @Override
    public GolfCourses getGolfCourseById(int golfCourseId) {

        GolfCourses golfCourse = null;
        String sql = "SELECT course_id, course_name, location, par FROM courses WHERE course_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, golfCourseId);
            if (results.next()) {
                golfCourse = mapRowToGolfCourse(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return golfCourse;

    }



    @Override
    public void deleteGolfCourseById(int golfCourseId) {

    }

    @Override
    public GolfCourses addGolfCourseToDatabase(int golfCourseId) {
        return null;
    }


    private GolfCourses mapRowToGolfCourse(SqlRowSet rs) {
        GolfCourses course = new GolfCourses();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
        course.setCourseLocation(rs.getString("location"));
        course.setParScore(rs.getInt("par"));
        return course;
    }
}
