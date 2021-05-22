package com.luizjedi.mongoproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luizjedi.mongoproject.domain.Post;
import com.luizjedi.mongoproject.resources.util.URL;
import com.luizjedi.mongoproject.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post user = service.findById(id);

		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text) {

		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);

		return ResponseEntity.ok().body(list);
	}
}