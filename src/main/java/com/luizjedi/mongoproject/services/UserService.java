package com.luizjedi.mongoproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjedi.mongoproject.domain.User;
import com.luizjedi.mongoproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // injeção automatica de dependencia.
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
}
