package com.formation.app.dao.jdbc;

import com.formation.app.dao.TripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;
import com.formation.app.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Long, Trip> {


    public List<Trip> findAll() {
        List<Trip> tripList = new ArrayList<>();

        String query = "SELECT * FROM Trip";
        try (Statement st = ConnectionManager.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tripList.add(mapToTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripList;
    }


    @Override
    public Trip createTrip(Trip tripToCreate) {
            Trip createdTrip = null;
            String query = "INSERT INTO Trip (departure,destination,price) VALUES (?,?,?)";
            Connection connection = ConnectionManager.getConnection();
            try(PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pst.setLong(1, tripToCreate.getDeparture().getId());
                pst.setLong(2, tripToCreate.getDestination().getId());
                pst.setFloat(3, tripToCreate.getPrice());
                pst.execute();

                ResultSet resultSet = pst.getGeneratedKeys();
                resultSet.next();
                Long id = resultSet.getLong(1);

                createdTrip = findTripById(id);

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
            return createdTrip;
        }

    private Trip mapToTrip(ResultSet rs) throws SQLException {
        JdbcPlaceDao jpd = new JdbcPlaceDao();
        Long id = rs.getLong("id");
        Place departure = jpd.findPlaceById(rs.getLong("departure"));
        Place destination = jpd.findPlaceById(rs.getLong("destination"));
        Float price = rs.getFloat("price");
        return new Trip(id,departure, destination,price);
    }


    @Override
    public Trip findTripById(Long id) {
        String query = "SELECT * FROM Trip WHERE id = ?";
        Trip foundTrip = null;
        try(PreparedStatement pst= ConnectionManager.getConnection().prepareStatement(query) ) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                foundTrip = mapToTrip(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundTrip;
    }


    @Override
    public boolean updateTrip(Trip trip) {
        return false;
    }

    @Override
    public boolean removeTrip(Trip trip) {
        return false;
    }

    @Override
    public List<Trip> findTripByDeparture(Place place) {
        return null;
    }

    @Override
    public List<Trip> findTripByDestination(Place place) {
        return null;
    }
}
