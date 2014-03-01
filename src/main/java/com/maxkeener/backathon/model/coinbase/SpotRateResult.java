package com.maxkeener.backathon.model.coinbase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotRateResult {
    private String amount;

    public String getAmount() {
        return amount;
    }
}
