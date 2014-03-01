package com.maxkeener.backathon.model.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopularPerson {
    Integer id;
    String name;
    @JsonProperty("known_for")
    List<KnownFor> knownFors;
    @JsonProperty("profile_path")
    String profilePath;

    public List<KnownFor> getKnownFors() {
        return knownFors;
    }

    public void setKnownFors(List<KnownFor> knownFors) {
        this.knownFors = knownFors;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
