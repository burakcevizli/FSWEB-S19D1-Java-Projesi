package com.movieRestApi.Movie.util;

import com.movieRestApi.Movie.dto.ActorResponse;
import com.movieRestApi.Movie.dto.MovieResponse;
import com.movieRestApi.Movie.entity.Actor;
import com.movieRestApi.Movie.entity.Movie;


import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static ActorResponse actorConverter(Actor actor){
        return new ActorResponse(actor.getFirstName(), actor.getLastName());
    }

    public static List<ActorResponse> actorResponsesConverter(List<Actor> actorList) {
        List<ActorResponse> actorResponsesList = new ArrayList<>();
        for (Actor actor : actorList) {
            ActorResponse actorResponse = new ActorResponse(actor.getFirstName(), actor.getLastName());
            actorResponsesList.add(actorResponse);
        }
        return actorResponsesList;
    }

    public static MovieResponse movieConvertor(Movie movie){
        List<ActorResponse> actorResponseList = new ArrayList<>();

        for(Actor actor : movie.getActorList()){
            actorResponseList.add(new ActorResponse(actor.getFirstName(), actor.getLastName()));
        }
        return new MovieResponse(movie.getName(), movie.getDirectorName(), (double) movie.getRating(),actorResponseList);
    }

    public static List<MovieResponse> movieListConverter (List<Movie> movies) {

        List<MovieResponse> movieResponseList = new ArrayList<>() ;
        for (Movie movie :movies){

            List<ActorResponse> actorResponseList = new ArrayList<>() ;
            for (Actor actor : movie.getActorList()){

                actorResponseList.add(new ActorResponse(actor.getFirstName(), actor.getLastName()));

            }

            movieResponseList.add(new MovieResponse(movie.getName(), movie.getDirectorName(), (double) movie.getRating(),actorResponseList));

        }
        return movieResponseList;


    }

}
