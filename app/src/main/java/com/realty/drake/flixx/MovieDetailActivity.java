package com.realty.drake.flixx;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.realty.drake.flixx.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {
    //View binding with ButterKnife
    @BindView(R.id.tvOverview)TextView tvOverview;
    @BindView(R.id.ratingBar) RatingBar rbBar;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvPopularity) TextView tvPopularity;
    @BindView(R.id.ibPoster) ImageView ibPoster;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);


        ArrayList<? extends Movie> Movie = getIntent().getParcelableArrayListExtra("Movie");
        int position = getIntent().getIntExtra("position",0);

        //Collect value from parcelable
        String originalTitle = Movie.get(position).getOriginalTitle();
        String overview = Movie.get(position).getOverview();
        double popularity = Movie.get(position).getPopularity();
        double rating = Movie.get(position).getRatingBar();




        //Set values
        tvTitle.setText(originalTitle);
        tvOverview.setText(overview);
        tvPopularity.setText(String.valueOf(popularity));
        rbBar.setRating((float) rating/2);

        //Loading circle for placeholder, ColorAccent has been used
        CircularProgressDrawable progressDrawable =
                new CircularProgressDrawable(this);
        progressDrawable.setStrokeWidth(5f);
        progressDrawable.setCenterRadius(30f);
        progressDrawable
                .setColorSchemeColors(Color.argb(255,0,150,136));
        progressDrawable.start();

        //Display the image
        Picasso.with(this)
                .load(Movie.get(position).getBackdropPath())
                .placeholder(progressDrawable)
                .into(ibPoster);





    }
}
