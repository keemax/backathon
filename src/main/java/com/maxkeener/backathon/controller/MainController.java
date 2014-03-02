package com.maxkeener.backathon.controller;


import com.maxkeener.backathon.apis.Bter;
import com.maxkeener.backathon.apis.Coinbase;
import com.maxkeener.backathon.apis.Instagram;
import com.maxkeener.backathon.apis.Tmdb;
import com.maxkeener.backathon.model.bter.Trade;
import com.maxkeener.backathon.model.instagram.SearchPerson;
import com.maxkeener.backathon.model.instagram.UserAndRandomPicture;
import com.maxkeener.backathon.model.tmdb.PopularPerson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {

    @ResponseBody
    @RequestMapping("/movie")
    public String movie(@RequestParam(value = "name", required = true) String name) {
        Tmdb tmdb = new Tmdb();
        PopularPerson result = null;
        try {
            result = tmdb.searchPersonMinPopularity(name);
        } catch (Exception e) {
        }

//        Coinbase coinbase = new Coinbase();
//        Double convertedValueBtc = coinbase.convertToBtc(20d);
//
//
//        Bter bter = new Bter();
//        Double btc = coinbase.convertToBtc(20d);
//        Trade lastTrade = bter.getLastTraded();
//
//        Double dogeBtcRate = Double.parseDouble(lastTrade.getPrice());


//
//        Instagram instagram = new Instagram();
//        UserAndRandomPicture userAndRandomPicture = new UserAndRandomPicture();
//        SearchPerson searchPerson = instagram.searchPerson(name);
//        userAndRandomPicture.setFullName(searchPerson.getFullName());
//        userAndRandomPicture.setUsername(searchPerson.getUsername());
//
//        userAndRandomPicture.setRandomUrl(instagram.getRandomUrlFromUser(searchPerson.getId()));


//        String html = "<html><body><h2>HELLO " + name + "!!!!!</h2>" +
//                      "<p>are you " + result.getName() + "???</p>" +
//                      "<p>I thoroughly enjoyed " + result.getKnownFors().get(0).getTitle() + "</p>" +
//                      "<p>fyi, you could buy that on dvd for</p>" +
//                    "<p>" + convertedValueBtc + " bitcoins ORRRR</p>" +
//                    "<p>" + (btc / dogeBtcRate) + " dogecoins!!!!!</p>" +
//                    "<p> or maybe you could be... " + userAndRandomPicture.getFullName() + "!!!</p>" +
//                    "<p> if so, I LOVED your recent post on instagram!</p>" +
//                    "<img src=\"" + userAndRandomPicture.getRandomUrl() + "\"/>" +
//
//                      "</body></hml>";

        if (result == null) {
            return "<html>\n" +
                    "  <head>\n" +
                    "    <title>whatevs</title>\n" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"doge.css\" />\n" +
                    "    <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" +
                    "    <style>\n" +
                    "    /* fullscreen setup */\n" +
                    "html, body {\n" +
                    "    /* any div up to fullscreen-cont must have this\n" +
                    "    in this case html and body */\n" +
                    "    height:100%;\n" +
                    "    min-height:100%;\n" +
                    "    font-family: \"Comic Sans MS\";\n" +
                    "}\n" +
                    ".fullscreen-cont,\n" +
                    ".fullscreen-img {\n" +
                    "    display:block;\n" +
                    "    position:relative;\n" +
                    "    min-width:100%;\n" +
                    "    min-height:100%;\n" +
                    "}\n" +
                    ".fullscreen-img {\n" +
                    "    display:block;\n" +
                    "    position:absolute;\n" +
                    "    z-index:1;\n" +
                    "    min-width:100%;\n" +
                    "    min-height:100%;\n" +
                    "    /* background position when .fullscreen-img overflows */\n" +
                    "    background:transparent url('http://i.imgur.com/ETXyHXX.jpg') center center no-repeat;\n" +
                    "    background-size:cover;\n" +
                    "}\n" +
                    ".content {\n" +
                    "    display:block;\n" +
                    "    position:relative;\n" +
                    "    z-index:2;\n" +
                    "}\n" +
                    "body {\n" +
                    "    margin: 0;\n" +
                    "    padding: 0;\n" +
                    " }\n" +
                    ".wow {\n" +
                    "  position: absolute;\n" +
                    "  font-size: 40px;\n" +
                    "}\n" +
                    "    </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <div class=\"fullscreen-cont\">\n" +
                    "      <div class=\"fullscreen-img\"></div>\n" +
                    "      <div class=\"content\">\n" +
                    "        <p class=\"wow\">such " + name + "</p> \n" +
                    "        <p class=\"wow\">very no celebrity</p> \n" +
                    "        <p class=\"wow\">so no movie</p> \n" +

                    "      </div>\n" +
                    "    </div>\n" +
                    "    <script>\n" +
                    "\n" +
                    "      var makeWow = function (){\n" +
                    "\n" +
                    "        var wows = $('.wow');\n" +
                    "        wows.each( function( index ) {\n" +
                    "          var divwidth = $(this).width();\n" +
                    "          var divheight = $(this).height();\n" +
                    "\n" +
                    "          // make position sensitive to size and document's width\n" +
                    "          var posx = (Math.random() * ($(document).width() - divwidth)).toFixed();\n" +
                    "          var posy = (Math.random() * ($(document).height() - divheight)).toFixed();\n" +
                    "\n" +
                    "          var colors = ['#ff0000', '#00ff00', '#0000ff'];\n" +
                    "          var randomColor = Math.floor(Math.random()*16777215).toString(16);\n" +
                    "          $(this).css({\n" +
                    "            'position':'absolute',\n" +
                    "            'z-index':'0',\n" +
                    "            'left':posx+'px',\n" +
                    "            'top':posy+'px',\n" +
                    "            'color': randomColor\n" +
                    "          });\n" +
                    "        });\n" +
                    "      }\n" +
                    "\n" +
                    "      makeWow();\n" +
                    "\n" +
                    "    </script>\n" +
                    "  </body>\n" +
                    "</html>";
        } else {

            String movie;
            if (result.getKnownFors() != null && result.getKnownFors().size() > 0) {
               movie =  result.getKnownFors().get(0).getTitle();
            } else {
                movie = "no movie";
            }


            return "<html>\n" +
                "  <head>\n" +
                "    <title>whatevs</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"doge.css\" />\n" +
                "    <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" +
                "    <style>\n" +
                "    /* fullscreen setup */\n" +
                "html, body {\n" +
                "    /* any div up to fullscreen-cont must have this\n" +
                "    in this case html and body */\n" +
                "    height:100%;\n" +
                "    min-height:100%;\n" +
                "    font-family: \"Comic Sans MS\";\n" +
                "}\n" +
                ".fullscreen-cont,\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "}\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:absolute;\n" +
                "    z-index:1;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "    /* background position when .fullscreen-img overflows */\n" +
                "    background:transparent url('http://i.imgur.com/ETXyHXX.jpg') center center no-repeat;\n" +
                "    background-size:cover;\n" +
                "}\n" +
                ".content {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    z-index:2;\n" +
                "}\n" +
                "body {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                " }\n" +
                ".wow {\n" +
                "  position: absolute;\n" +
                "  font-size: 40px;\n" +
                "}\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"fullscreen-cont\">\n" +
                "      <div class=\"fullscreen-img\"></div>\n" +
                "      <div class=\"content\">\n" +
                "        <p class=\"wow\">such " + name + "</p> \n" +
                "        <p class=\"wow\">very " + result.getName() + "</p> \n" +
                "        <p class=\"wow\">so " + movie + "</p> \n" +

                "      </div>\n" +
                "    </div>\n" +
                "    <script>\n" +
                "\n" +
                "      var makeWow = function (){\n" +
                "\n" +
                "        var wows = $('.wow');\n" +
                "        wows.each( function( index ) {\n" +
                "          var divwidth = $(this).width();\n" +
                "          var divheight = $(this).height();\n" +
                "\n" +
                "          // make position sensitive to size and document's width\n" +
                "          var posx = (Math.random() * ($(document).width() - divwidth)).toFixed();\n" +
                "          var posy = (Math.random() * ($(document).height() - divheight)).toFixed();\n" +
                "\n" +
                "          var colors = ['#ff0000', '#00ff00', '#0000ff'];\n" +
                "          var randomColor = Math.floor(Math.random()*16777215).toString(16);\n" +
                "          $(this).css({\n" +
                "            'position':'absolute',\n" +
                "            'z-index':'0',\n" +
                "            'left':posx+'px',\n" +
                "            'top':posy+'px',\n" +
                "            'color': randomColor\n" +
                "          });\n" +
                "        });\n" +
                "      }\n" +
                "\n" +
                "      makeWow();\n" +
                "\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";
        }

    }


    @ResponseBody
    @RequestMapping("/crypto")
    public String crypto() {

        int rand = new Random().nextInt() % 1000;

        Coinbase coinbase = new Coinbase();
        Double convertedValueBtc = coinbase.convertToBtc(rand);


        Bter bter = new Bter();
        Double btc = coinbase.convertToBtc(rand);
        Trade lastTrade = bter.getLastTraded();

        Double dogeBtcRate = Double.parseDouble(lastTrade.getPrice());


        String bestHtml = "<html>\n" +
                "  <head>\n" +
                "    <title>whatevs</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"doge.css\" />\n" +
                "    <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" +
                "    <style>\n" +
                "    /* fullscreen setup */\n" +
                "html, body {\n" +
                "    /* any div up to fullscreen-cont must have this\n" +
                "    in this case html and body */\n" +
                "    height:100%;\n" +
                "    min-height:100%;\n" +
                "    font-family: \"Comic Sans MS\";\n" +
                "}\n" +
                ".fullscreen-cont,\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "}\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:absolute;\n" +
                "    z-index:1;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "    /* background position when .fullscreen-img overflows */\n" +
                "    background:transparent url('http://i.imgur.com/ETXyHXX.jpg') center center no-repeat;\n" +
                "    background-size:cover;\n" +
                "}\n" +
                ".content {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    z-index:2;\n" +
                "}\n" +
                "body {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                " }\n" +
                ".wow {\n" +
                "  position: absolute;\n" +
                "  font-size: 40px;\n" +
                "}\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"fullscreen-cont\">\n" +
                "      <div class=\"fullscreen-img\"></div>\n" +
                "      <div class=\"content\">\n" +
                "        <p class=\"wow\">such " + rand + " usd</p> \n" +
                "        <p class=\"wow\">very " + convertedValueBtc + " bitcoin</p> \n" +
                "        <p class=\"wow\">so " + (btc / dogeBtcRate) + " dogecoin</p> \n" +

                "      </div>\n" +
                "    </div>\n" +
                "    <script>\n" +
                "\n" +
                "      var makeWow = function (){\n" +
                "\n" +
                "        var wows = $('.wow');\n" +
                "        wows.each( function( index ) {\n" +
                "          var divwidth = $(this).width();\n" +
                "          var divheight = $(this).height();\n" +
                "\n" +
                "          // make position sensitive to size and document's width\n" +
                "          var posx = (Math.random() * ($(document).width() - divwidth)).toFixed();\n" +
                "          var posy = (Math.random() * ($(document).height() - divheight)).toFixed();\n" +
                "\n" +
                "          var colors = ['#ff0000', '#00ff00', '#0000ff'];\n" +
                "          var randomColor = Math.floor(Math.random()*16777215).toString(16);\n" +
                "          $(this).css({\n" +
                "            'position':'absolute',\n" +
                "            'z-index':'0',\n" +
                "            'left':posx+'px',\n" +
                "            'top':posy+'px',\n" +
                "            'color': randomColor\n" +
                "          });\n" +
                "        });\n" +
                "      }\n" +
                "\n" +
                "      makeWow();\n" +
                "\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";

        return bestHtml;
    }

    @ResponseBody
    @RequestMapping("/insta")
    public String insta(@RequestParam(value = "name", required = true) String name) {

        Instagram instagram = new Instagram();
        UserAndRandomPicture userAndRandomPicture = new UserAndRandomPicture();
        SearchPerson searchPerson = instagram.searchPerson(name);
        userAndRandomPicture.setFullName(searchPerson.getFullName());
        userAndRandomPicture.setUsername(searchPerson.getUsername());

        userAndRandomPicture.setRandomUrl(instagram.getRandomUrlFromUser(searchPerson.getId()));


        String bestHtml = "<html>\n" +
                "  <head>\n" +
                "    <title>whatevs</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"doge.css\" />\n" +
                "    <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" +
                "    <style>\n" +
                "    /* fullscreen setup */\n" +
                "html, body {\n" +
                "    /* any div up to fullscreen-cont must have this\n" +
                "    in this case html and body */\n" +
                "    height:100%;\n" +
                "    min-height:100%;\n" +
                "    font-family: \"Comic Sans MS\";\n" +
                "}\n" +
                ".fullscreen-cont,\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "}\n" +
                ".fullscreen-img {\n" +
                "    display:block;\n" +
                "    position:absolute;\n" +
                "    z-index:1;\n" +
                "    min-width:100%;\n" +
                "    min-height:100%;\n" +
                "    /* background position when .fullscreen-img overflows */\n" +
                "    background:transparent url('http://i.imgur.com/ETXyHXX.jpg') center center no-repeat;\n" +
                "    background-size:cover;\n" +
                "}\n" +
                ".content {\n" +
                "    display:block;\n" +
                "    position:relative;\n" +
                "    z-index:2;\n" +
                "}\n" +
                "body {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                " }\n" +
                ".wow {\n" +
                "  position: absolute;\n" +
                "  font-size: 40px;\n" +
                "}\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"fullscreen-cont\">\n" +
                "      <div class=\"fullscreen-img\"></div>\n" +
                "      <div class=\"content\">\n" +
                "        <p class=\"wow\">such " + name + "</p> \n" +
                "        <p class=\"wow\">very " + userAndRandomPicture.getFullName() + "</p> \n" +
                "        <p class=\"wow\">so " + userAndRandomPicture.getUsername() + " on instagram</p> \n" +
                "        <img class=\"wow\" src=\"" + userAndRandomPicture.getRandomUrl() + "\" width=\"200\"> \n" +

                "      </div>\n" +
                "    </div>\n" +
                "    <script>\n" +
                "\n" +
                "      var makeWow = function (){\n" +
                "\n" +
                "        var wows = $('.wow');\n" +
                "        wows.each( function( index ) {\n" +
                "          var divwidth = $(this).width();\n" +
                "          var divheight = $(this).height();\n" +
                "\n" +
                "          // make position sensitive to size and document's width\n" +
                "          var posx = (Math.random() * ($(document).width() - divwidth)).toFixed();\n" +
                "          var posy = (Math.random() * ($(document).height() - divheight)).toFixed();\n" +
                "\n" +
                "          var colors = ['#ff0000', '#00ff00', '#0000ff'];\n" +
                "          var randomColor = Math.floor(Math.random()*16777215).toString(16);\n" +
                "          $(this).css({\n" +
                "            'position':'absolute',\n" +
                "            'z-index':'0',\n" +
                "            'left':posx+'px',\n" +
                "            'top':posy+'px',\n" +
                "            'color': randomColor\n" +
                "          });\n" +
                "        });\n" +
                "      }\n" +
                "\n" +
                "      makeWow();\n" +
                "\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";

        return bestHtml;


    }

    @ResponseBody
    @RequestMapping("/raw")
    public String rawIndex(@RequestParam(value = "name", required = true) String name) {
                Tmdb tmdb = new Tmdb();
        PopularPerson result = tmdb.searchPersonMinPopularity(name);

        Coinbase coinbase = new Coinbase();
        Double convertedValueBtc = coinbase.convertToBtc(20d);


        Bter bter = new Bter();
        Double btc = coinbase.convertToBtc(20d);
        Trade lastTrade = bter.getLastTraded();

        Double dogeBtcRate = Double.parseDouble(lastTrade.getPrice());



        Instagram instagram = new Instagram();
        UserAndRandomPicture userAndRandomPicture = new UserAndRandomPicture();
        SearchPerson searchPerson = instagram.searchPerson(name);
        userAndRandomPicture.setFullName(searchPerson.getFullName());
        userAndRandomPicture.setUsername(searchPerson.getUsername());

        userAndRandomPicture.setRandomUrl(instagram.getRandomUrlFromUser(searchPerson.getId()));


        String html = "<html><body><h2>HELLO " + name + "!!!!!</h2>" +
                      "<p>are you " + result.getName() + "???</p>" +
                      "<p>I thoroughly enjoyed " + result.getKnownFors().get(0).getTitle() + "</p>" +
                      "<p>fyi, you could buy that on dvd for</p>" +
                    "<p>" + convertedValueBtc + " bitcoins ORRRR</p>" +
                    "<p>" + (btc / dogeBtcRate) + " dogecoins!!!!!</p>" +
                    "<p> or maybe you could be... " + userAndRandomPicture.getFullName() + "!!!</p>" +
                    "<p> if so, I LOVED your recent post on instagram!</p>" +
                    "<img src=\"" + userAndRandomPicture.getRandomUrl() + "\"/>" +

                      "</body></hml>";
        return html;
    }
}
