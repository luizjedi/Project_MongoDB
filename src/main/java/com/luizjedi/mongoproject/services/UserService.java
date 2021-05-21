package com.luizjedi.mongoproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjedi.mongoproject.domain.User;
import com.luizjedi.mongoproject.dto.UserDTO;
import com.luizjedi.mongoproject.repository.UserRepository;
import com.luizjedi.mongoproject.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // injeção automatica de dependencia.
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {

		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}

	private void updateDate(User newObj, User obj) {
		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
