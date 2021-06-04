package com.formation.app;

import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.model.Place;

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

//            case "3":
//
//                break;
//
//            case "4":
//
//                break;

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
        System.out.println("6 - Add a trip");
        System.out.println("7 - Find a trip");
        System.out.println("8 - Remove a trip");

        System.out.println("9 - Quit");
        System.out.println();
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



}
