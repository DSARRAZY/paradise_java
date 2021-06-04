package com.formation.app.dao.jbdc;

import com.formation.app.dao.TripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao {


    @Override
    public Long createTrip(Trip trip) {
        return null;
    }

    @Override
    public Trip findTripById(Long id) {
        return null;
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
