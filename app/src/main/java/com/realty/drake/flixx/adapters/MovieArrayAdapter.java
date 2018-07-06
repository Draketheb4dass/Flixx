package com.realty.drake.flixx.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.realty.drake.flixx.R;
import com.realty.drake.flixx.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data for position
        Movie movie = getItem(position);
        //Check if existing use being reuse
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        //bind ImageView
        ImageView ivImage = convertView.findViewById(R.id.ivMovieImage);
        //clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        //Loading circle for placeholder, ColorAccent has been used
        CircularProgressDrawable progressDrawable =
                new CircularProgressDrawable(getContext());
        progressDrawable.setStrokeWidth(5f);
        progressDrawable.setCenterRadius(30f);
        progressDrawable.setColorSchemeColors(Color.argb(255,0,150,136));
        progressDrawable.start();

        Picasso.with(getContext())
                .load(movie.getPosterPath())
                .placeholder(progressDrawable)
                .into(ivImage);

        //Return the View
        return  convertView;

    }
}

