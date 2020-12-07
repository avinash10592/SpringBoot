package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nisum.api.GitHubUser;
import com.nisum.service.GitServiceImp;

@Controller
public class GitController {
	@Autowired
	private GitServiceImp gitService;

	@GetMapping(value = "/repo")
	public ResponseEntity<List<GitHubUser>> getAllProjects() {
		gitService.getAllProjects();
		return getAllProjects();

	}
}