package com.example.bookstore.main;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.model.Movie;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    List<Movie> movies;
    MainContract.Presenter presenter;

    public MainAdapter(List<Movie> movies, MainContract.Presenter presenter) {
        this.movies = movies;
        this.presenter = presenter;
    }

    // 1. ViewHolder
    public static class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView title;
        TextView summary;

        public MainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.thumbnail = itemView.findViewById(R.id.thumbnail);
//            this.title = itemView.findViewById();
//            this.summary = itemView.findViewById();
        }
    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_view, parent, false);

        return new MainAdapterViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder, int position) {
        Movie movie = movies.get(position);
        String thumbnailPath = movie.getSmallCoverImage();
        Log.d("thumbnailPath ==> ", thumbnailPath);
//        holder.thumbnail.setImageURI(thumbnailPath);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }




    // 2. onCreateViewHolder
    // 3. onBindViewHolder
    // 4. getItemCount

}
