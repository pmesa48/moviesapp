package com.android.pmesa.moviesapp.ui;

import android.content.Context;

import com.android.pmesa.moviesapp.model.entities.Result;

import java.util.List;

/**
 * Created by pablomesa on 6/03/16.
 */
public interface MainView {
    void renderPopularMovies(List<Result> movies);
    void onError();
    Context getContext();
}
