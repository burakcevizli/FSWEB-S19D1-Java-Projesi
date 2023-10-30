package com.movieRestApi.Movie.service;

import com.movieRestApi.Movie.entity.Movie;
import com.movieRestApi.Movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isPresent()){
            return movieOptional.get();
        }
        throw new RuntimeException("Movie with given id is not exist"  + id);
    }

    @Override
    public Movie delete(long id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
        return movie;
    }
}
