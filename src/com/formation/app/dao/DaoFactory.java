package com.formation.app.dao;

import java.sql.SQLException;

public class DaoFactory {

    private static PlaceDao placeDao;
    private static TripDao tripDao;


    private DaoFactory() {
    }

    public static PlaceDao getPlaceDao() throws SQLException {
        if(placeDao == null) {
            placeDao = new JdbcPlaceDao();
        }
        return placeDao;
    }

    public static TripDao getTripDao() throws SQLException {
        if(tripDao == null) {
            tripDao = new JdbcTripDao();
        }
        return tripDao;
    }

}
