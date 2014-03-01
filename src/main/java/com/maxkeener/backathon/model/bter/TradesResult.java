package com.maxkeener.backathon.model.bter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TradesResult {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    String result;
    @JsonProperty("data")
    List<Trade> trades;
    String elapsed;
}
