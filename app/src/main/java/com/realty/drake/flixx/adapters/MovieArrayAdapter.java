package com.realty.drake.flixx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.realty.drake.flixx.R;
import com.realty.drake.flixx.models.Movie;

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
        if(convertView== null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.item_movie, parent, false);
        }

        //bind ImageView
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        //Return the View
        return  convertView;

    }
}

