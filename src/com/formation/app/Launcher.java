package com.formation.app;

import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.model.Place;

import java.sql.SQLException;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws SQLException {

        // REQUETE READ
        List<Place> placeList = DaoFactory.getPlaceDao().findAll();
        for (Place f: placeList) {
            System.out.println("ID " + f.getId() + " Place : " + f.getName());
        }



    }
}
