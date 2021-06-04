package com.formation.app.dao;

import com.formation.app.model.Place;

import java.util.List;
import java.sql.SQLException;

public interface PlaceDao<ID, T> {

    void createPlace(Place place);
    Place findPlaceById(Long id);
    boolean updatePlace(Place place);
    boolean removePlace(Place p);
    Place findAllPlace();
    List<T> findAll();

}
