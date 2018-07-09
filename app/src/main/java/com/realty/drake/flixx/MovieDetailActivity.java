package com.realty.drake.flixx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.realty.drake.flixx.models.Movie;

import java.util.ArrayList;

import butterknife.BindView;

public class MovieDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(4.5f);

        ArrayList<? extends Movie> Movie = getIntent().getParcelableArrayListExtra("Movie");
        //Movie movie = getIntent().getParcelableExtra("Movie");


        String posterPath;
        String originalTitle = Movie.get(0).getOriginalTitle();
        String overview;
        String backdropPath;

        TextView titleMovie = findViewById(R.id.TitleMovie);
        titleMovie.setText(originalTitle);


    }
}
