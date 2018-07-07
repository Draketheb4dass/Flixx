package com.realty.drake.flixx.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    private String posterPath;
    private String originalTitle;
    private String overview;
    private String backdropPath;

    //Constructor that extract fields from JsonObject
    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
    }

    //Getters
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getOverview() {
        return overview;
    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    //Iterate through arrayList
    public static ArrayList<Movie> fromJsonArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return results;
    }
}
