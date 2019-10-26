package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.base.BaseView;
import com.example.bookstore.model.Movie;

import java.util.List;

public class MainContract {
    public interface View
            extends BaseView {
        //book list view에 반영
        void fetchMoviesDone(List<Movie> movies);
    }

    public interface Presenter
            extends BasePresenter<View> {
        //book list req
        void fetchMovies(int pageNum);
        void fetchMoviesDone(List<Movie> movies);
    }
}
