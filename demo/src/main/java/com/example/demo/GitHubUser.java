package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {
    private List tree;

    public List getTree() {
        return tree;
    }

    public void setTree(List tree) {
        this.tree = tree;
    }
}
