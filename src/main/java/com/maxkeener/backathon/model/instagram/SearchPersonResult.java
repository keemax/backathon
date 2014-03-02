package com.maxkeener.backathon.model.instagram;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPersonResult {
    public List<SearchPerson> getData() {
        return data;
    }

    public void setData(List<SearchPerson> data) {
        this.data = data;
    }

    List<SearchPerson> data;


}
