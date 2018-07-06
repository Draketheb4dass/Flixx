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

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_movie, movies );
    }

     static class ViewHolder {
        @BindView(R.id.ivMovieImage)
        ImageView posterPath;
        @BindView(R.id.tvTitle)
        TextView originalTitle;
        @BindView(R.id.tvOverview)
        TextView overview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //get the data for position
        Movie movie = getItem(position);

        ViewHolder viewHolder;
        //Check if existing use being reuse
        if(convertView != null) {
            //View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();

        } else {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder = new ViewHolder(convertView);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);


        }



        //Populate the data from the data object via the viewHolder object
        //into the template view.
        assert movie != null;
        viewHolder.originalTitle.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());

        //Loading circle for placeholder, ColorAccent has been used
        CircularProgressDrawable progressDrawable =
                new CircularProgressDrawable(getContext());
        progressDrawable.setStrokeWidth(5f);
        progressDrawable.setCenterRadius(30f);
        progressDrawable.setColorSchemeColors(Color.argb(255,0,150,136));
        progressDrawable.start();

        Picasso.with(getContext())
                .load(movie.getPosterPath())
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(progressDrawable)
                .into(viewHolder.posterPath);

        //Return the View
        return  convertView;

    }
}

