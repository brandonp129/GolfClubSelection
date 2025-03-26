package com.techelevator.controller;

import com.techelevator.dao.JdbcGolfBagDao;
import com.techelevator.dao.JdbcUserDao;

public class GolfBagController {

    private final JdbcUserDao jdbcUserDao;
    private final JdbcGolfBagDao jdbcGolfBagDao;

    public GolfBagController(JdbcUserDao jdbcUserDao, JdbcGolfBagDao jdbcGolfBagDao) {
        this.jdbcUserDao = jdbcUserDao;
        this.jdbcGolfBagDao = jdbcGolfBagDao;
    }
}
