package com.example.bookstore.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.bookstore.R;
import com.example.bookstore.base.BaseActivity;
import com.example.bookstore.model.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View
{

    private String _TAG = "MainActivity ==>";
    MainAdapter adapter;
    List<Movie> movies = new ArrayList<Movie>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    ProgressBar progress;


    int startPageNumber = 1;


    @Override
    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.fetchMovies(startPageNumber);

        initRecyclerView();
//        btnFetchItems.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO 클릭시 다운스트림 발생
//                mPresenter.fetchMovies(1);
//            }
//        });

    }

    private void initRecyclerView() {
        adapter = new MainAdapter(movies, mPresenter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fetchMoviesDone(List<Movie> movies) {
        if (startPageNumber == 1)
        {
            progress.setVisibility(View.GONE);
        }

        Log.d(_TAG, " fetchMoviesDone count : " + movies.size());
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();

        if (startPageNumber <= 3)
        {
            mPresenter.fetchMovies(startPageNumber++);
        }
    }
}
