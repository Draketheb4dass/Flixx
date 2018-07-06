package com.realty.drake.flixx.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.realty.drake.flixx.R;
import com.realty.drake.flixx.models.Movie;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie>) {
        super(context, R.layout.item_movie )
    }

