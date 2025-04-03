package com.techelevator.dao;

import com.techelevator.model.GolfClubs;
import com.techelevator.model.GolfCourses;

import java.util.List;

public interface GolfCoursesDao {

    List<GolfCourses> getListOfGolfCourses();

    GolfCourses getGolfCourseById(int golfCourseId);

    void deleteGolfCourseById(int golfCourseId);

    GolfCourses addGolfCourseToDatabase(int golfCourseId);
}


