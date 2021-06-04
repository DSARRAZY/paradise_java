package com.formation.app.dao;

import com.formation.app.dao.jbdc.JdbcPlaceDao;
import com.formation.app.dao.jbdc.JdbcTripDao;

import java.sql.SQLException;

public class DaoFactory {

    private DaoFactory() {
    }

    public static JdbcPlaceDao getPlaceDao() throws SQLException {
            return new JdbcPlaceDao();
    }

    public static JdbcTripDao getTripDao() throws SQLException {
             return new JdbcTripDao();

    }

}
