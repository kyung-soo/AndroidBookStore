package com.example.bookstore.main;

import android.util.Log;

import com.example.bookstore.base.BasePresenterImpl;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.RepositoryImpl;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    private String _TAG = "MainPresenter ==>";

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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<Movie>>) movies -> {
                                   Log.d(_TAG, "movies json : " + movies);
                                   view.fetchMoviesDone(movies);
                           }
                        , (Consumer<Throwable>)throwable ->  {
                                Log.d(_TAG, throwable.getMessage());
                        }
                );
    }
}
