package com.movieRestApi.Movie.controller;


import com.movieRestApi.Movie.entity.Actor;
import com.movieRestApi.Movie.service.ActorService;
import com.movieRestApi.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public ActorController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<Actor> findAll(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable long id){
        return actorService.findById(id);
    }

    @PostMapping("/")
    public Actor save(@RequestBody Actor actor){
        return actorService.save(actor);
    }
    @PutMapping("/{id}")
    public Actor update(@RequestBody Actor actor,  @PathVariable long id){
        Actor existingMovieActor = findById(id);
        if(existingMovieActor !=null){
            existingMovieActor.setFirstName(actor.getFirstName());
            existingMovieActor.setLastName(actor.getLastName());
            existingMovieActor.setGender(actor.getGender());
            existingMovieActor.setBirthday(actor.getBirthday());
        }
        return existingMovieActor;
    }

    @DeleteMapping("/{id}")
    public Actor movie(@PathVariable long id){
        Actor movie = actorService.findById(id);
        actorService.delete(id);
        return movie;
    }
}
