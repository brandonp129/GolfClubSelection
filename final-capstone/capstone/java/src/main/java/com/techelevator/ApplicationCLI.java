package com.techelevator;

import com.techelevator.Factors.Calculations;
import com.techelevator.TemporaryView.Services.Menu;

/*
 * This class should control the workflow of the application, but not do any other work
 *
 * The menu class should communicate with the user, but do no other work
 *
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CandyStore class to do any work and pass the results between those 2 classes.
 */
public class ApplicationCLI {

    private Menu menu;
    private Calculations calculations;

    public ApplicationCLI() {
        menu = new Menu();
        calculations = new Calculations();

    }

    public void run() {

        boolean isRunning = true;

        int courseElevation = menu.getCourseElevation();
        int temperature = menu.getTemperature();
        int windSpeeds = menu.getWindSpeed();
        while(isRunning) {

            if (menu.isTheRoundOver()) {

                int shotDistance = menu.getShotLength();

                boolean windDirection = menu.isIntoTheWind();

                if (windDirection) {

                    int requiredShotDistance = calculations.shotDistanceCalculation(courseElevation, temperature,
                            windSpeeds, shotDistance);

                    menu.clubSelection(requiredShotDistance);
                }else {

                    boolean downWind = menu.isDownwind();

                    if (downWind) {

                        windSpeeds = (-windSpeeds);

                        int requiredShotDistance = calculations.shotDistanceCalculation(courseElevation, temperature,
                                windSpeeds, shotDistance);

                        menu.clubSelection(requiredShotDistance);
                    } else {

                        windSpeeds = 0;

                        int requiredShotDistance = calculations.shotDistanceCalculation(courseElevation, temperature,
                                windSpeeds, shotDistance);

                        menu.clubSelection(requiredShotDistance);
                    }
                }

            } else {

                isRunning = false;
            }


        }

        System.exit(0);
    }

    private void loginMenu() {

    }

    public static void main(String[] args) {

        ApplicationCLI cli = new ApplicationCLI();
        cli.run();
    }
}

