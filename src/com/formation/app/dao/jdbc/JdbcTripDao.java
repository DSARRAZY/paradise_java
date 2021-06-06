package com.formation.app.dao.jdbc;

import com.formation.app.dao.TripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;
import com.formation.app.util.ConnectionManager;

import java.sql.*;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Long, Trip> {

    @Override
    public Trip createTrip(Trip tripToCreate) {
            Trip createdTrip = null;
            String query = "INSERT INTO Trip (price,destination,departure) VALUES (?,?,?)";
            Connection connection = ConnectionManager.getConnection();
            try(PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pst.setFloat(1, tripToCreate.getPrice());
                pst.setLong(2, tripToCreate.getDestination().getId());
                pst.setLong(3, tripToCreate.getDeparture().getId());
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
        Long id = rs.getLong("id");
        Float price = rs.getFloat("price");
        String departure = rs.getString("departure");
        String destination = rs.getString("destination");
        return new Trip(id, price, destination, departure);
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
