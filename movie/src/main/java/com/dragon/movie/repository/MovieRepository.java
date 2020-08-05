package com.dragon.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dragon.movie.model.MovieDetails;

@Repository
public interface MovieRepository extends CrudRepository<MovieDetails, Integer>{

}
