package com.movieRestApi.Movie.controller;

import com.movieRestApi.Movie.entity.Movie;
import com.movieRestApi.Movie.service.ActorService;
import com.movieRestApi.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable long id){
        return movieService.findById(id);
    }

    @PostMapping("/")
    public Movie save(@RequestBody Movie movie){
        return movieService.save(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@RequestBody Movie movie,  @PathVariable long id){
        Movie existingMovie = findById(id);
        if(existingMovie !=null){
            existingMovie.setName(movie.getName());
            existingMovie.setDirectorName(movie.getDirectorName());
            existingMovie.setRating(movie.getRating());
            existingMovie.setReleaseDate(movie.getReleaseDate());
        }
        return existingMovie;
    }

    @DeleteMapping("/{id}")
    public Movie movie(@PathVariable long id){
        Movie movie = movieService.findById(id);
        movieService.delete(id);
        return movie;
    }
}
