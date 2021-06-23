package com.ramonlima.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramonlima.workshopmongo.domain.Post;
import com.ramonlima.workshopmongo.repositories.PostRepository;
import com.ramonlima.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
	}
	
	public List<Post> findByTitle(String text) {
		// return repository.findByTitleContainingIgnoreCase(text);
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		// Acrescentar 24horas para a pesquisa ser completa daquele dia pesquisado
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);		
	}
}
