package com.maxkeener.backathon.controller;


import com.keemax.model.Order;
import com.maxkeener.backathon.apis.Bter;
import com.maxkeener.backathon.apis.Coinbase;
import com.maxkeener.backathon.model.bter.Trade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class DogecoinController {

    @RequestMapping("/dogecoin/convert")
    public String convertToDoge(@RequestParam(value = "usd", required = true) Double usd) {
        Bter bter = new Bter();
        Coinbase coinbase = new Coinbase();

        Double btc = coinbase.convertToBtc(usd);
        Trade lastTrade = bter.getLastTraded();

        Double dogeBtcRate = Double.parseDouble(lastTrade.getPrice());
        return Double.toString(btc / dogeBtcRate);

    }
}
