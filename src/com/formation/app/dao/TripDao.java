package com.formation.app.dao;

import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.util.List;

public interface TripDao {

    Long createTrip(Trip trip);
    Trip findTripById(Long id);
    boolean updateTrip(Trip trip);
    boolean removeTrip(Trip trip);
    List<Trip> findTripByDeparture(Place place);
    List<Trip> findTripByDestination(Place place);
}
