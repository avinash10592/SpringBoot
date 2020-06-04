package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

	DAOUser findByUsername(String username);
}