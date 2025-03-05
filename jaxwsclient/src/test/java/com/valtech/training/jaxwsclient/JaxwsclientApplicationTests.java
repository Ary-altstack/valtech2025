package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.webservices.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	
	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Jax WS"));
		movieServiceWS.createMovie(new Movie("Interstellar","Sci-Fi","English",List.of("Matthew McCouanghey","Anne Hathway")));
		movieServiceWS.createMovie(new Movie("Fight Club","Drama","English",List.of("Brad Pitt","Edward Norton")));
		System.out.println(movieServiceWS.getAllMovies());
		
		
	}

}
