package com.example.bookstore.logic.remote;

import android.util.Log;

import com.example.bookstore.logic.DataSource;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.remote.services.MovieApiService;
import com.example.bookstore.model.Movie;
import com.example.bookstore.model.ResponseMovie;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class RemoteDataSourceImpl implements DataSource {

    Repository repository;

    private String _TAG = "RemoteDataSourceImpl ==> ";

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        // Repository를 리턴
        //TODO 서버연동 및 데이터 변환
        //TODO retrofit 연동 / gson / RxJava

        MovieApiService service = NetRetrofit.getInstance().getRetrofit().create(MovieApiService.class);
        return service.fetchMovies()
                .map(new Function<ResponseMovie, List<Movie>>() {
                    @Override
                    public List<Movie> apply(ResponseMovie responseMovie) throws Exception {
                        Log.d(_TAG, "Response movie : " + responseMovie.toString());
                        return responseMovie.getData().getMovies();
                    }
                })
        ;
    }
}
