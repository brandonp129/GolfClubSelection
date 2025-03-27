package com.techelevator.controller;

import com.techelevator.dao.JdbcGolfBagDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.GolfBags;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class GolfBagController {

    private final JdbcUserDao jdbcUserDao;
    private final JdbcGolfBagDao jdbcGolfBagDao;

    public GolfBagController(JdbcUserDao jdbcUserDao, JdbcGolfBagDao jdbcGolfBagDao) {
        this.jdbcUserDao = jdbcUserDao;
        this.jdbcGolfBagDao = jdbcGolfBagDao;
    }

    @RequestMapping(path="/golfBag", method = RequestMethod.POST)
    public void saveGolfBagToUser(@RequestBody GolfBags golfBags, @RequestParam int id) {

        jdbcGolfBagDao.addGolfBagToDataBaseAndUserList(id, golfBags);

    }
}
