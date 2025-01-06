package com.techelevator.TemporaryView;

import java.util.Scanner;




public class Menu {

    private static final Scanner in = new Scanner(System.in);

    public int getCourseElevation() {

        System.out.println("To start we need some information: ");

        System.out.println("What is the elevation above sea level  of the city that you are playing in (in Feet)?");
        String elevation = in.next();
        int courseElevation = Integer.parseInt(elevation);

        return courseElevation;
    }

    public int getTemperature() {

        System.out.println("Please enter the temperature that you are playing in (in F): ");
        String temperature = in.next();

        int courseTemperature = Integer.parseInt(temperature);


        return courseTemperature;
    }

    public int getWindSpeed() {

        System.out.println("Please enter the wind in MPH: ");
        String wind = in.next();

        int windSpeed = Integer.parseInt(wind);

        return windSpeed;
    }

    public boolean windDirectionChanges() {

        System.out.println("Are there any changed to the direction of the wind? (y/n)");
        String windChange = in.next();

        boolean isWindChange = true;

        if(!windChange.equalsIgnoreCase("y")) {
            isWindChange = false;
        }

        return isWindChange;
    }

    public int getShotLength() {

        System.out.println("How far of a shot do you have to hit in yards?");
        String shotLength = in.next();

        int shotDistance = Integer.parseInt(shotLength);

        return shotDistance;
    }

    public boolean isIntoTheWind() {

        System.out.println("Is your shot into the wind? y/n");
        String wind = in.next();

        boolean isIntoWind = true;

        if (!wind.equalsIgnoreCase("y")) {
            isIntoWind = false;
        }

        return isIntoWind;
    }

    public boolean isDownwind() {

        System.out.println("Is your shot downwind? y/n");
        String wind = in.next();

        boolean isDownwind = true;

        if (!wind.equalsIgnoreCase("y")) {
            isDownwind = false;
        }

        return isDownwind;
    }

    public boolean isTheRoundOver() {

        System.out.println("Are you finished? y/n");
        String playing = in.next();

        boolean isPlaying = true;

        if (!playing.equalsIgnoreCase("n")) {
            isPlaying = false;
        }

        return isPlaying;
    }

    public void clubSelection(int shotDistance) {

        System.out.println("you need to hit the ball "  + shotDistance + " yards!");
    }




}
