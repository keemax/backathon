package com.maxkeener.backathon.apis;

import com.maxkeener.backathon.model.tmdb.PopularPerson;
import com.maxkeener.backathon.model.tmdb.PopularPersonResult;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tmdb extends BasicApi {
    private final String baseUrl = props.get("tmdb.baseurl");
    private final String api_key = props.get("tmdb.apikey");

    public PopularPerson searchPersonMinPopularity(String firstName) {
        String requestUrl = baseUrl + "/person/popular?api_key=" + api_key;
        HttpGet searchPersonGet = new HttpGet(requestUrl);

        String resp = executeRequest(searchPersonGet);
        try {
            PopularPersonResult result = mapper.readValue(resp, PopularPersonResult.class);
            int page = 1;
            int maxPages = result.getTotalPages();
            while (page < maxPages) {
                for (PopularPerson popularPerson : result.getResults()) {
                    String personName = popularPerson.getName().toLowerCase();
                    if (personName.contains(firstName.toLowerCase())) {
                        return popularPerson;
                    }
                }

                HttpGet newPageGet = new HttpGet(requestUrl + "&page=" + page++);
                String newPageResp = executeRequest(newPageGet);
                result = mapper.readValue(newPageResp, PopularPersonResult.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
