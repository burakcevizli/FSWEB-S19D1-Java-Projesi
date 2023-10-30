package com.movieRestApi.Movie.service;

import com.movieRestApi.Movie.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor save(Actor actor);
    Actor findById(long id);
    Actor delete(long id);
}
