package com.example.demo.model;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class JobStandardizer {
    private String[] jobs;
    
    public JobStandardizer() {
        this.jobs = new String[]{"Engineer", "Accountant"};
    }

    // Not working as expected, review when @param job have two or more words
    public String standardize(String job) throws Exception {
        if (job.isEmpty()) throw new Exception("The field job is empty");
        String closestJobMatch = ""; 
        int distance = Integer.MAX_VALUE;
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        for (String j : this.jobs) {
            int currentDistance = levenshteinDistance.apply(j, job);
            if (currentDistance < distance) {
                closestJobMatch = j;
                distance = currentDistance;
            }
        }
        return closestJobMatch;
    }
}
