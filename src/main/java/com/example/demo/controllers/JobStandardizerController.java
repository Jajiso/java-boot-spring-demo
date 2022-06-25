package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JobStandardizer;

@RestController
public class JobStandardizerController {

    @GetMapping("/job_standarize")
    public String getUrlStatusMessage(@RequestParam String job) {
        String returnMessage = "";
        JobStandardizer standardizer = new JobStandardizer();
        String standardizedJob;
        try {
            standardizedJob = standardizer.standardize(job);
            returnMessage = "You searched for: " + job + " and the closest match title for this one is: " + standardizedJob;
        } catch (Exception e) {
            returnMessage = "ERROR - e: " + e;
        }
        return returnMessage;
    }
}
