package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenterImpl;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.RepositoryImpl;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    Repository repository;
    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchMovies(int pageNum) {
        //TODO Repo에서 data 가져온다
        //TODO RxJava로 View로 업스트림을 올린다.
        this.repository.fetchMovies(pageNum)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });
    }

    @Override
    public void fetchMoviesDone(List<Movie> movies) {

    }
}
