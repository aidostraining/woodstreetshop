package com.epam.shop.dao;

import com.epam.shop.connection.ConnectionPoolException;
import com.epam.shop.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T extends Entity> {

    void create(T t) throws ConnectionPoolException;

    List<T> getAll() throws SQLException, ConnectionPoolException;

    T getById(int id) throws SQLException, ConnectionPoolException;

    void update(T t) throws SQLException, ConnectionPoolException;

    void delete(T t) throws ConnectionPoolException;


}