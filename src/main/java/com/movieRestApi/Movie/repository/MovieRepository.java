package com.movieRestApi.Movie.repository;

import com.movieRestApi.Movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
