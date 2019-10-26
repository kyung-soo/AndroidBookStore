package com.example.bookstore.logic.remote.services;

import com.example.bookstore.model.Movie;
import com.example.bookstore.model.ResponseMovie;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MovieApiService {

    @GET("list_movies.json")
    Single<ResponseMovie> fetchMovies();


}
