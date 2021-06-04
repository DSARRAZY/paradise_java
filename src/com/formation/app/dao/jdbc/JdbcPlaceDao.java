package com.formation.app.dao.jdbc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;
import com.formation.app.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao<Long, Place> {

    @Override
    public List<Place> findAll() {
        List<Place> placeList = new ArrayList<>();

        String query = "SELECT * FROM Place";
        try (Statement st = ConnectionManager.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                placeList.add(mapToPlace(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }

    private static Place mapToPlace(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Place(id, name);
    }

    @Override
    public void createPlace(Place place) {
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
