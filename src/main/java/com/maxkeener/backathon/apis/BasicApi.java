package com.maxkeener.backathon.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxkeener.backathon.constant.PropertiesGetter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BasicApi {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    PropertiesGetter props = PropertiesGetter.getInstance();
    ObjectMapper mapper = new ObjectMapper();

    String executeRequest(HttpRequestBase httpRequest) {
        CloseableHttpResponse resp = null;
        try {
            resp = httpClient.execute(httpRequest);
            return EntityUtils.toString(resp.getEntity());
        } catch (Exception e) {
            System.err.println("UH OH");
            e.printStackTrace();
        } finally {
            if (resp != null) {
                try {
                    resp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
