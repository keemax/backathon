package com.maxkeener.backathon.apis;

import com.maxkeener.backathon.model.coinbase.SpotRateResult;
import org.apache.http.client.methods.HttpGet;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coinbase extends BasicApi {
    private final String baseUrl = props.get("coinbase.baseurl");

    public Double convertToBtc(double usd) {
        HttpGet spotRateGet = new HttpGet(baseUrl + "/prices/spot_rate");

        String resp = executeRequest(spotRateGet);
        try {
            SpotRateResult result = mapper.readValue(resp, SpotRateResult.class);
            Double rate = Double.parseDouble(result.getAmount());
            return usd / rate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
