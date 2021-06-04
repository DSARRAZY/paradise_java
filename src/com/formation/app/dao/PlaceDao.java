package com.formation.app.dao;

import com.formation.app.model.Place;

import java.sql.SQLException;
import java.util.List;

public interface PlaceDao<ID, T> {

    T createPlace(T object) throws SQLException;
    T findPlaceById(ID id);
    boolean updatePlace(Place place);
    boolean removePlace(Place p);
    Place findAllPlace();
    List<T> findAll();

}
