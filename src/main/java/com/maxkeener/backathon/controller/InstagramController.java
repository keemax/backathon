package com.maxkeener.backathon.controller;

import com.maxkeener.backathon.apis.Instagram;
import com.maxkeener.backathon.model.instagram.SearchPerson;
import com.maxkeener.backathon.model.instagram.UserAndRandomPicture;
import org.apache.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class InstagramController {

    @RequestMapping("/instagram/search")
    public ResponseEntity<UserAndRandomPicture> searchPerson(@RequestParam(value = "name", required = true) String name) {
        Instagram instagram = new Instagram();
        UserAndRandomPicture userAndRandomPicture = new UserAndRandomPicture();
        SearchPerson searchPerson = instagram.searchPerson(name);
        userAndRandomPicture.setFullName(searchPerson.getFullName());
        userAndRandomPicture.setUsername(searchPerson.getUsername());

        userAndRandomPicture.setRandomUrl(instagram.getRandomUrlFromUser(searchPerson.getId()));
        return new ResponseEntity<UserAndRandomPicture>(userAndRandomPicture, HttpStatus.OK);
    }
}
