package com.dragon.movie.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.movie.model.MovieDetails;
import com.dragon.movie.service.MovieDetailsService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/movies")
public class MovieController {
	
	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieDetailsService movieDetailsService;
	
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<MovieDetails>> getAllMovieDetails() {
		logger.info("Getting all the movie Details");
		List<MovieDetails> movieDetails= movieDetailsService.getAllMovies();
		logger.info("Got all the movies"+movieDetails.toString());
		//return movieDetails;
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}
	
	@GetMapping("/getMovies/{id}")
	public Optional<MovieDetails> getMovieDetails(@PathVariable("id")int movieId) {
		Optional<MovieDetails> movieDetailsById= movieDetailsService.getByMovies(movieId);
		return movieDetailsById;
	}
	
	@PostMapping("/insertMovies")
	public String insertMovieDetails(@RequestBody MovieDetails movieDetails) {
		movieDetailsService.insertMovie(movieDetails);
		return "Successfully inserted Movie Details";
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteMovieDetails(@PathVariable("id") int movieId) {
		String mgs = movieDetailsService.deleteMovie(movieId);
		return mgs;
	}


}
