package com.movieRestApi.Movie.service;


import com.movieRestApi.Movie.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie save(Movie movie);
    Movie findById(long id);
    Movie delete(long id);
}
