package com.movieRestApi.Movie.dto;

import java.util.List;

public record MovieResponse(String name, String directorName, Double rating, List<ActorResponse> actors) {
}
