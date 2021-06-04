package com.formation.app.dao;

import com.formation.app.model.Place;

public interface PlaceDao {

    Long createPlace(Place place);
    Place findPlaceById(Long id);
    boolean updatePlace(Place place);
    boolean removePlace(Place p);
    Place findAllPlace();



}
