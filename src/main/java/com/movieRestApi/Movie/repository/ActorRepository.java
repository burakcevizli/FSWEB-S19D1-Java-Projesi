package com.movieRestApi.Movie.repository;

import com.movieRestApi.Movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
