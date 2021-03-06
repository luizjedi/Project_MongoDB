package com.luizjedi.mongoproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjedi.mongoproject.domain.Post;
import com.luizjedi.mongoproject.repository.PostRepository;
import com.luizjedi.mongoproject.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // injeção automatica de dependencia.
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}