package com.realty.drake.flixx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class MovieDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(4.5f);
    }
}
