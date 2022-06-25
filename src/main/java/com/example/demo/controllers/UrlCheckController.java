package com.example.demo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
    private final  String APP_IS_UP = "App is up!";
    private final  String APP_IS_DOWN = "App is down!";
    private final  String INCORRECT_URL = "URL is incorrect!";


    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode() ;
            if (responseCode  >= 200 && responseCode < 400 ) {
                returnMessage = APP_IS_UP + " responseCode: " + responseCode;
            } else {
                returnMessage = APP_IS_DOWN + " responseCode: " + responseCode;
            }
        } catch (MalformedURLException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = "IOException, e ( "+e+" )";
        }
        
        return returnMessage;
    }
}
