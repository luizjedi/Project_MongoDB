package com.luizjedi.mongoproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjedi.mongoproject.domain.User;
import com.luizjedi.mongoproject.repository.UserRepository;
import com.luizjedi.mongoproject.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // injeção automatica de dependencia.
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
