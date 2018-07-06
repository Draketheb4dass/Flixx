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
        super(context, R.layout.item_movie, movies );
    }

    private static class ViewHolder {
        ImageView posterPath;
        TextView originalTitle;
        TextView overview;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data for position
        Movie movie = getItem(position);

        ViewHolder viewHolder;
        //Check if existing use being reuse
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.posterPath = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.originalTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            //View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();


        }



        //Populate the data from the data object via the viewHolder object
        //into the template view.

        viewHolder.originalTitle.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());
        // Return the completed view to render on screen


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
                .into(viewHolder.posterPath);

        //Return the View
        return  convertView;

    }
}

