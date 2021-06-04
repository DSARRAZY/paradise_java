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
        String reponse = scanner.nextLine();

        switch (reponse) {
            case "1":
                allPlace();
                break;

            case "2":

                break;

            case "3":

                break;

            case "4":

                break;

            default:
                System.out.println("Erreur de saisi clavier !! \n");
                break;
        }
    }






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

    private static void allPlace() throws SQLException {
        List<Place> placeList = DaoFactory.getPlaceDao().findAll();
            for (Place f: placeList) {
           System.out.println("ID " + f.getId() + " Place : " + f.getName());
       }
    }





}
