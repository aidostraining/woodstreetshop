package com.epam.shop.dao;

import com.epam.shop.connection.ConnectionPool;
import com.epam.shop.connection.ConnectionPoolException;
import com.epam.shop.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao implements BaseDao<Customer> {

    private ConnectionPool connectionPool;
    private Connection connection;

    private void setParametersToCustomer(Customer customer, ResultSet resultSet) throws SQLException {
        customer.setName(resultSet.getString("name"));
        customer.setSurname(resultSet.getString("surname"));
        customer.setEmail(resultSet.getString("email"));
        customer.setLogin(resultSet.getString("login"));
        customer.setPassword(resultSet.getString("password"));
        customer.setRoleId(resultSet.getInt("roleId"));
    }

    @Override
    public void create(Customer customer) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (
                PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER " +
                                "(NAME, SURNAME, EMAIL, LOGIN, PASSWORD, ROLE_ID)" + "VALUES (?,?,?,?,?,?)")) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getLogin());
            statement.setString(5, customer.getPassword());
            statement.setInt(6, customer.getRoleId());
            statement.executeUpdate();
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

        @Override
        public List<Customer> getAll () throws SQLException, ConnectionPoolException {
            List<Customer> customers = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    setParametersToCustomer(customer, resultSet);
                    customers.add(customer);
                }
            } finally {
                connectionPool.returnConnection(connection);
            }
            return customers;
        }

        @Override
        public Customer getById ( int id) throws SQLException, ConnectionPoolException {
            Customer customer = new Customer();
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            try (PreparedStatement statement = connection.prepareStatement("SELECT C.ID, C.NAME, C.SURNAME,C.EMAIL, C.LOGIN, C.PASSWORD, " +
                    "R.ROLE FROM CUSTOMER C, ORDER O, ROLE R WHERE C.ROLE_ID=R.ID AND C.ID=?")) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    setParametersToCustomer(customer, resultSet);
                }
            } finally {
                connectionPool.returnConnection(connection);
            }
            return customer;
        }

        @Override
        public void update (Customer customer) throws SQLException, ConnectionPoolException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void delete ( int id, Customer customer) throws ConnectionPoolException {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE ID = ?")) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } finally {
                connectionPool.returnConnection(connection);
            }
        }
    }