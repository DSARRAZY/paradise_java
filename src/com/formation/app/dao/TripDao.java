package com.formation.app.dao;

import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.sql.SQLException;
import java.util.List;

public interface TripDao<ID, T>{

    T createTrip(T object) throws SQLException;
    T findTripById(Long id);
    List<T> findAll();
    boolean updateTrip(Trip trip);
    boolean removeTrip(Trip trip);
    List<Trip> findTripByDeparture(Place place);
    List<Trip> findTripByDestination(Place place);
}
