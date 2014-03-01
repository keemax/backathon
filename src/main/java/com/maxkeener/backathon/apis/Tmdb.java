package com.maxkeener.backathon.apis;

import com.maxkeener.backathon.model.tmdb.Person;
import com.maxkeener.backathon.model.tmdb.SearchPersonResult;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

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

    public List<Person> searchPerson(String query) {
        System.out.println(baseUrl + "/person/search?api_key=" + api_key + "&query=" + query);
        HttpGet searchPerson = new HttpGet(baseUrl + "/search/person?api_key=" + api_key + "&query=" + query);

        String resp = executeRequest(searchPerson);
        System.out.println(resp);
        try {
            SearchPersonResult result = mapper.readValue(resp, SearchPersonResult.class);
            return result.getResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
