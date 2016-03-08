package com.android.pmesa.moviesapp.model.service;

import com.android.pmesa.moviesapp.common.Utils;
import com.android.pmesa.moviesapp.model.entities.PopularMovies;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

/**
 * Created by pablomesa on 6/03/16.
 */
public class TMDBAPI {

     public interface ROUTES {

//        //CONFIGURATIONS
//        @GET("/configuration")
//        void configurations(@Query("api_key") String apiKey, Callback<GetImageConfigurationResponse> callback);

//        //MOVIE SEARCH AUTOCOMPLETE
//        @GET("/search/movie")
//        void search(@Query("api_key") String apiKey, @Query("query") String query, Callback<SearchMovieResponse> callback);
//
//        //MOVIE DETAIL
//        @GET("/movie/{id}")
//        void movieDetails(@Query("api_key") String apiKey, @Path("id") int movieID, Callback<MovieDetailEntity> callback);
//
//        //MOVIE IMAGES
//        @GET("/movie/{id}/images")
//        void movieImages(@Query("api_key") String apiKey, @Path("id") int movieID, Callback<GetMovieImagesResponse> callback);
        @GET("movie/popular")
        Call<PopularMovies> popularMovies(@Query("api_key") String apiKey, @Query("pages") int pages);

         @GET("movie/upcoming")
         Call<PopularMovies> upcomingMovies(@Query("api_key") String apiKey, @Query("pages") int pages);
    }

    public static ROUTES apiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit.create(ROUTES.class);
    }

}
