package com.dragon.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.movie.exception.MovieNotFound;
import com.dragon.movie.model.MovieDetails;
import com.dragon.movie.repository.MovieRepository;

@Service
public class MovieDetailsService {
	
	@Autowired
	MovieRepository movierepository;
	
	public List<MovieDetails> getAllMovies() {
		List<MovieDetails> allMovies= (List<MovieDetails>) movierepository.findAll();

		if(allMovies.size() > 0) {
            return allMovies;
        } else {
            return new ArrayList<MovieDetails>();
        }
	}

	public Optional<MovieDetails> getByMovies(int movieId) {
		Optional<MovieDetails> movieDetail = movierepository.findById(movieId);
		if(movieDetail.isPresent()) {
			return movieDetail;
		}else {
			return null;
		}
	}

	public Optional<MovieDetails> insertMovie(MovieDetails movieDetails) {
		Optional<MovieDetails> movieDetail = movierepository.findById(movieDetails.getMovieId());
		if(movieDetail.isPresent()) {
			MovieDetails updateMovie = movieDetail.get();
			//updateMovie.setMovieId(movieDetails.getMovieId());
			updateMovie.setMovieName(movieDetails.getMovieName());
			updateMovie.setReleaseDate(movieDetails.getReleaseDate());
			updateMovie.setMovieDescription(movieDetails.getMovieDescription());
			movierepository.save(updateMovie);
		}else {
			movierepository.save(movieDetails);
		}
		return null;
	}

	public String deleteMovie(int movieId) {
		Optional<MovieDetails> movieDetail = movierepository.findById(movieId);
		
		if(movieDetail.isPresent()) {
			movierepository.deleteById(movieId);
		}else {
			return "Movie is not found or Already deleted";
		}
		return "Record Deleted";		
	}

}
