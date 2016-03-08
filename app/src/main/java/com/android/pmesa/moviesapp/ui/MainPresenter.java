package com.android.pmesa.moviesapp.ui;

import com.android.pmesa.moviesapp.common.Utils;
import com.android.pmesa.moviesapp.model.service.TMDBAPI;
import com.android.pmesa.moviesapp.model.entities.PopularMovies;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by pablomesa on 6/03/16.
 */
public class MainPresenter {
    TMDBAPI tmdbapi;
    MainView mainView;
    public MainPresenter(MainView mMainView){
        mainView = mMainView;
        fetchPopularMovies(Utils.TMBD_KEY,1);
    }
    public void fetchPopularMovies(final String apiKey, final int pages){
        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchPopularMoviesAux(apiKey,pages);
            }
        }).start();
    }

    public void fetchPopularMoviesAux(final String apiKey, final int pages){
        Call<PopularMovies> call = TMDBAPI.apiService().popularMovies(apiKey, pages);
        try {
            Response<PopularMovies> response = call.execute();
            if(response.isSuccess()){
                PopularMovies popularMovies = response.body();
                mainView.renderPopularMovies(popularMovies.getResults());
            }else{
                mainView.onError();
            }
        } catch (IOException e) {
            e.printStackTrace();
            mainView.onError();
        }
    }


    public void fetchUpcomingMovies(final String apiKey, final int pages){
        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchUpcomingMoviesAux(apiKey, pages);
            }
        }).start();
    }

    public void fetchUpcomingMoviesAux(final String apiKey, final int pages){
        Call<PopularMovies> call = TMDBAPI.apiService().upcomingMovies(apiKey, pages);
        try {
            Response<PopularMovies> response = call.execute();
            if(response.isSuccess()){
                PopularMovies popularMovies = response.body();
                mainView.renderPopularMovies(popularMovies.getResults());
            }else{
                mainView.onError();
            }
        } catch (IOException e) {
            e.printStackTrace();
            mainView.onError();
        }
    }
}
