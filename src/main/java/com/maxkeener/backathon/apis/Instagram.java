package com.maxkeener.backathon.apis;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.maxkeener.backathon.model.instagram.SearchPerson;
import com.maxkeener.backathon.model.instagram.SearchPersonResult;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Instagram extends BasicApi {
    private final String baseUrl = props.get("instagram.baseurl");
    private final String clientId = props.get("instagram.clientid");

    public SearchPerson searchPerson(String name) {
        HttpGet httpGet = new HttpGet(baseUrl + "/users/search?q=" + name + "&client_id=" + clientId);

        String response = executeRequest(httpGet);
        try {
            SearchPersonResult searchPersonResult = mapper.readValue(response, SearchPersonResult.class);
            return searchPersonResult.getData().get(0);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;

    }

    public String getRandomUrlFromUser(String userId) {
        HttpGet httpGet = new HttpGet(baseUrl + "/users/" + userId + "/media/recent?client_id=" + clientId);

        String result = executeRequest(httpGet);
        try {
            Map resultMap = mapper.readValue(result, Map.class);
            List<Map> data = (List<Map>) resultMap.get("data");
            if (data == null) {
                System.out.println("data is null");
            }
            Map firstResult = data.get(0);
            if (firstResult == null) {
                System.out.println("first result null");
            }

            Map randomImages = (Map) firstResult.get("images");
            if (randomImages == null) {
                System.out.println("random images null");
            }
            return (String) ((Map) randomImages.get("standard_resolution")).get("url");

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return null;
    }
}
