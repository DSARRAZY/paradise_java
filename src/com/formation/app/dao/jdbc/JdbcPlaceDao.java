package com.formation.app.dao.jdbc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;
import com.formation.app.util.ConnectionManager;

import java.sql.*;
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
    public Place createPlace(Place placeToCreate) {
        Place createdPlace = null;
        String query = "INSERT INTO Place (name) VALUES (?)";
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, placeToCreate.getName());
            pst.execute();

            ResultSet resultSet = pst.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);

            createdPlace = findPlaceById(id);

            // Fetching inserted id
            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return createdPlace;
    }

    @Override
    public Place findPlaceById(Long id) {
        String query = "SELECT * FROM Place WHERE id = ?";
       Place foundPlace = null;
        try(PreparedStatement pst= ConnectionManager.getConnection().prepareStatement(query) ) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                foundPlace = mapToPlace(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPlace;
    }

    @Override
    public boolean updatePlace(Place placeToUpdate) {
        int updateRows = 0;
        String query = "UPDATE Place SET name=? WHERE id=?";
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, placeToUpdate.getName());
            pst.setLong(2, placeToUpdate.getId());
            pst.execute();

            updateRows = pst.executeUpdate();

            // Fetching inserted id
            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return updateRows > 0;

    }



//    @Override
//    public boolean removePlace(Place) {
//        return false;
//    }
//
//    @Override
//    public Place findAllPlace() {
//        return null;
//    }


}
