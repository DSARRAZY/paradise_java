package com.formation.app.dao.jbdc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JbdcPlaceDao extends JbdcDao implements PlaceDao {


    @Override
    public Long createPlace(Place place) {
        return null;
    }

    @Override
    public Place findPlaceById(Long id) {
        return null;
    }

    @Override
    public boolean updatePlace(Place place) {
        return false;
    }

    @Override
    public boolean removePlace(Place p) {
        return false;
    }

    @Override
    public Place findAllPlace() {
        return null;
    }
}
