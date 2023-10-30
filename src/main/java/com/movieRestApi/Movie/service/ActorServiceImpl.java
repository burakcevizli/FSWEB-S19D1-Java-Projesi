package com.movieRestApi.Movie.service;

import com.movieRestApi.Movie.entity.Actor;
import com.movieRestApi.Movie.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if(actorOptional.isPresent()){
            return actorOptional.get();
        }
        throw new RuntimeException("Actor with given id is not exist " + id);
    }

    @Override
    public Actor delete(long id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return actor;
    }
}
