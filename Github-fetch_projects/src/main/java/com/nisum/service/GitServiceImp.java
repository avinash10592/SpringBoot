package com.nisum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nisum.api.GitHubUser;

@Configuration
@Service
public class GitServiceImp implements GitService {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	public RestTemplate restTemplate;
	@Override
	public List<GitHubUser> getAllProjects() {
		// TODO Auto-generated method stub
		restTemplate.getForObject(
		"https://api.github.com/repos/avinash10592/SpringBoot/git/trees/1faed8a192486039d0ce37f4ad11a502a6403452",
		GitHubUser.class);
		return getAllProjects();
	}
	
}
