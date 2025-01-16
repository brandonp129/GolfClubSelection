package com.techelevator.model;

public class GolfCourses {

    private int courseId;

    private String courseName;

    private String courseLocation;

    private int parScore;

    public GolfCourses() {

    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public int getParScore() {
        return parScore;
    }

    public void setParScore(int parScore) {
        this.parScore = parScore;
    }
}
