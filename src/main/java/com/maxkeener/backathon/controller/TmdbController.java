package com.maxkeener.backathon.controller;

import com.maxkeener.backathon.apis.Tmdb;
import com.maxkeener.backathon.model.tmdb.PopularPerson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class TmdbController {

    @RequestMapping("/tmdb/person")
    public ResponseEntity<PopularPerson> getPersonByName(@RequestParam(value = "name", required = true) String name) {
        Tmdb tmdb = new Tmdb();
        PopularPerson result = tmdb.searchPersonMinPopularity(name);
        return new ResponseEntity<PopularPerson>(result, HttpStatus.OK);
    }
}
