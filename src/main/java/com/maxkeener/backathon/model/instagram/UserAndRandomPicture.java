package com.maxkeener.backathon.model.instagram;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAndRandomPicture {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRandomUrl() {
        return randomUrl;
    }

    public void setRandomUrl(String randomUrl) {
        this.randomUrl = randomUrl;
    }

    String username;
    String fullName;
    String randomUrl;

}
