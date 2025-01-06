package com.techelevator.Factors;

public class Calculations {

    public int shotDistanceCalculation(int elevation, int temperature, int windSpeed, int shotDistance) {

        int newShotDistance = 0;

        newShotDistance = shotDistanceWithElevation(elevation, shotDistance);
        newShotDistance = shotDistanceWithTemperature(temperature, newShotDistance);
        newShotDistance = shotDistanceWithWind(windSpeed, newShotDistance);

        return newShotDistance;
    }

    public int shotDistanceWithElevation(int elevation, int shotDistance) {

        double percentChange = elevation * .00116;

        int newDistance = shotDistance - ((int) (shotDistance * (percentChange / 100)));

        return newDistance;
    }

    public int shotDistanceWithTemperature(int temperature, int newShotDistance) {

        int tempDifference = 70 - temperature;

        newShotDistance -= ((tempDifference / 10) * 2);

        return  newShotDistance;
    }

    public int shotDistanceWithWind(int windSpeed, int newShotDistance) {

        int distanceChangePercentage = 0;

        if (windSpeed > 0) {

            distanceChangePercentage = (int) (windSpeed * .01);
            newShotDistance -= (newShotDistance * distanceChangePercentage);
        } else if (windSpeed < 0) {
            distanceChangePercentage = (int) (windSpeed * .005);
            newShotDistance += (newShotDistance * distanceChangePercentage);

        }

        return newShotDistance;
    }

}
