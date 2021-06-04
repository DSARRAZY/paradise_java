package com.formation.app.dao.jbdc;

import com.formation.app.util.ConnectionManager;

import java.sql.Connection;

public abstract class JdbcDao {

    private Connection connection;

    public JdbcDao() {
        this.connection = ConnectionManager.getConnection();
    }
}
