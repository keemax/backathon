package com.maxkeener.backathon.controller;

import com.keemax.consts.MarketConst;
import com.keemax.exchanges.Bter;
import com.keemax.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class DogeController {

    @RequestMapping("/dogeify")
    public String dogeify(@RequestParam(value = "message", required = true) String message) {
        return "such " + message;
    }

    @RequestMapping("/bter/lowestsell")
    public ResponseEntity<Order> lowestSell() {
        Bter bter = new Bter(MarketConst.DOGE_BTC);
        try {
            Order order = bter.getLowestSell();
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
