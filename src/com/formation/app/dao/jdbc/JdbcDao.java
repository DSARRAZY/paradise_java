package com.formation.app.dao.jdbc;

import com.formation.app.model.Place;
import com.formation.app.util.ConnectionManager;

import java.sql.Connection;

public abstract class JdbcDao {

    private Connection connection;

    public JdbcDao() {
        this.connection = ConnectionManager.getConnection();
    }

}

