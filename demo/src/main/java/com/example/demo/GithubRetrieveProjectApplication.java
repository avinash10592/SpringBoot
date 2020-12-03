package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@SpringBootApplication
public class GithubRetrieveProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubRetrieveProjectApplication.class, args);
        {
            RestTemplate restTemplate = new RestTemplate();
            GitHubUser user = restTemplate.getForObject("https://api.github.com/repos/avinash10592/SpringBoot/git/trees/1faed8a192486039d0ce37f4ad11a502a6403452", GitHubUser.class);

            for (LinkedHashMap<String, String> repo : user) {
                System.out.println(repo.get("name"));
            }
        }

    }
}
