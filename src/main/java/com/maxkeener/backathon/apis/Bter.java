package com.maxkeener.backathon.apis;

import com.maxkeener.backathon.model.bter.Trade;
import com.maxkeener.backathon.model.bter.TradesResult;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bter extends BasicApi{
    private final String baseUrl = props.get("bter.baseurl");

    public Trade getLastTraded() {
        HttpGet lastTradeGet = new HttpGet(baseUrl + "/trade/doge_btc");
        String result = executeRequest(lastTradeGet);

        try {
            TradesResult tradesResult = mapper.readValue(result, TradesResult.class);

            return tradesResult.getTrades().get(0);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
