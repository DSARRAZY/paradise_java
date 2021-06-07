package com.formation.app;

import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.dao.jdbc.JdbcTripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        displayMenu();
        int number = readInt(scanner,"Enter un number only : ", "This is not a number. Try again : ");

        switch (number) {
            case 1:
                allPlace();
                break;

            case 2:
                addPlace();
                break;

          case 3:
                findPlace();
            break;

            case 4:
                editPlace();
               break;

            case 5:
                //removePlace();
                break;

            case 6:
                allTrip();
                break;

            case 7:
                addTrip();
                break;

            case 8:
                findTrip();
                break;

            case 9:
                removeTrip();
                break;

            default:
                System.out.println("Wrong input \n");
                break;
        }
    }


    /**
     * Display Menu client
     */
    private static void displayMenu() {
        System.out.println();
        System.out.println("What do you want to do ?");

        System.out.println("1 - List all of places");
        System.out.println("2 - Add a place");
        System.out.println("3 - Find a place");
        System.out.println("4 - Edit a place");
        System.out.println("5 - Remove a place");
       ;
        System.out.println("6 - List all of trip");
        System.out.println("7 - Add a trip");
        System.out.println("8 - Find a trip");
        System.out.println("9 - Remove a trip");

        System.out.println("10 - Quit");
        System.out.println();
    }

    /**
     * Control input Client
     * @param scanner
     * @param prompt
     * @param promptOnError
     * @return
     */
    public static int readInt(Scanner scanner, String prompt, String promptOnError) {

        System.out.print(prompt);

        while ( !scanner.hasNextInt() ) {
            System.out.print(promptOnError);
            scanner.nextLine();
        }

        final int input = scanner.nextInt();
        scanner.nextLine();
        return input;

    }

    /**
     * Display All Place
     * @throws SQLException
     */
    private static void allPlace() throws SQLException {
        List<Place> placeList = DaoFactory.getPlaceDao().findAll();
            for (Place f: placeList) {
           System.out.println("ID " + f.getId() + " Place : " + f.getName());
       }
    }

    /**
     *  Add a place by user
     * @throws SQLException
     */
    private static void addPlace() throws SQLException {
        Place place = new Place();
        System.out.print("Name: ");
        String name = new Scanner(System.in).nextLine();
        place.setName(name);
        Place id = DaoFactory.getPlaceDao().createPlace(place);

        if(id != null) {
            System.out.println("Place added with the ID=" + id.getId() + ".");
        } else {
            System.out.println("Error, impossible to add the place.");
        }
    }


    /**
     * Find a place by id
     * @return
     * @throws SQLException
     */
    private static Place findPlace() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the id of the place : ");
        int choice = scanner.nextInt();
        Place place = DaoFactory.getPlaceDao().findPlaceById((long) choice);
        displayPlace(place);
        return place;
    }


    /**
     * Display a place
     * @param place
     */
    private static void displayPlace(Place place) {
        if(place != null) {
            System.out.println("Place : " + place.getName());
        } else {
            System.out.println("Unknown place.");
        }
    }


    /**
     * Edit a place
     * @throws SQLException
     */
    private static void editPlace() throws SQLException {
        Place place = findPlace();
        if(place != null) {
            System.out.print("Enter the new name : ");
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            place.setName(newName);
            if(DaoFactory.getPlaceDao().updatePlace(place)) {
                System.out.println("Place updated !");
            } else {
                System.out.println("Error during update.");
            }
        }
    }

//    /**
//     * Delete a place
//     * @throws SQLException
//     */
//    private static void removePlace() throws SQLException {
//        Place place = findPlace();
//        if(place != null) {
//            System.out.println("All trips with this Place will be removed with it.\n Are you sure you want to remove it ? [yes/no]");
//            Scanner scanner = new Scanner(System.in);
//            String choice = scanner.next();
//            if(choice.equalsIgnoreCase("yes")) {
//                if(DaoFactory.getPlaceDao().removePlace(place)) {
//                    System.out.println("Place removed !");
//                } else {
//                    System.out.println("Impossible to remove the Place.");
//                }
//            }
//        }
//    }

    /**
     * All of Trip
     * @throws SQLException
     */
    private static void allTrip() throws SQLException {
        List<Trip> tripList = DaoFactory.getTripDao().findAll();
        for (Trip f: tripList) {
            System.out.println("ID " + f.getId() + " Trip cost  " + f.getPrice() + " to " + f.getDestination().getName()+ " from "+f.getDeparture().getName());
        }
    }

    /**
     * Add a trip
     * @throws SQLException
     */
    private static void addTrip() throws SQLException {
        Trip trip = new Trip();

        System.out.print("Departure: ");
        Place place = findPlace();
        trip.setDeparture(place);

        System.out.print("Destination: ");
        Place place1 = findPlace();
        trip.setDestination(place1);

        System.out.print("Price: ");
        Float price = Float.valueOf(new Scanner(System.in).nextInt());
        trip.setPrice(price);

        Trip id = DaoFactory.getTripDao().createTrip(trip);

        if (id != null) {
            System.out.println("Trip added with the ID= " + id.getId() + " FROM " + trip.getDeparture().getName());
        } else {
            System.out.println("Error, impossible to add the trip.");
        }
    }


    private static void removeTrip() throws SQLException {
        Trip trip = findTrip();
        if (trip != null) {
            System.out.println("Are you sure you want to remove it ? [yes/no]");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("yes")) {
                if (DaoFactory.getTripDao().removeTrip(trip)) {
                    System.out.println("Trip removed !");
                } else {
                    System.out.println("Impossible to remove the Trip.");
                }
            }
        }
    }

    /**
     * Find a trip
     * @return
     * @throws SQLException
     */
        private static Trip findTrip() throws SQLException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the id of the trip : ");
            long choice = scanner.nextInt();
            Trip trip = DaoFactory.getTripDao().findTripById((long) choice);
            displayTrip(trip);
            return trip;
        }

    /**
     * Display a trip
     * @param trip
     */
    private static void displayTrip(Trip trip) {
        if(trip!= null) {
            System.out.println("Trip: " + trip.getId());
        } else {
            System.out.println("Unknown place.");
        }
    }



}



