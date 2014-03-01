package com.maxkeener.backathon.controller;

import com.maxkeener.backathon.apis.Coinbase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class CoinbaseController {

    @RequestMapping("/bitcoin/convert")
    public String convertToBtc(@RequestParam(value = "usd", required = true) Double usd) {
        Coinbase coinbase = new Coinbase();
        Double convertedValue = coinbase.convertToBtc(usd);
        return convertedValue.toString();
    }
}
