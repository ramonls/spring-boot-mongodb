package com.ramonlima.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ramonlima.workshopmongo.domain.Post;
import com.ramonlima.workshopmongo.domain.User;
import com.ramonlima.workshopmongo.dto.AuthorDTO;
import com.ramonlima.workshopmongo.repositories.PostRepository;
import com.ramonlima.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		// Apagar nossas informações do banco de dados
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex GReen", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("22/06/2021"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));		
		Post post2 = new Post(null, sdf.parse("10/01/2019"), "Bom dia", "Uma linda manhã!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
