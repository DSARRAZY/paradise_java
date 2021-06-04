package com.formation.app.dao.jbdc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao {


    @Override
    public Long createPlace(Place place) {
        return null;
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
