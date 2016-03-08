package com.android.pmesa.moviesapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pmesa.moviesapp.R;
import com.android.pmesa.moviesapp.common.Utils;
import com.android.pmesa.moviesapp.model.entities.Result;
import com.android.pmesa.moviesapp.ui.adapter.MovieAdapter;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    ImageView imageMovie;
    TextView txtTitle;
    TextView txtYear;
    TextView txtOverview;
    TextView txtLanguage;
    TextView txtReleaseDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Result movie = (Result)getIntent().getSerializableExtra("movie");
        imageMovie = (ImageView)findViewById(R.id.img_backdrop);
        txtYear = (TextView)findViewById(R.id.movie_release_year);
        txtTitle = (TextView)findViewById(R.id.movie_original_title);
        txtOverview = (TextView)findViewById(R.id.overview);
        txtLanguage = (TextView)findViewById(R.id.language);
        txtReleaseDate = (TextView)findViewById(R.id.release_date);

        Picasso.with(this).load(MovieAdapter.BASE_URL+"/w1000"+movie.getBackdropPath()).into(imageMovie);
        txtTitle.setText(movie.getTitle());
        txtYear.setText(Utils.getYearFromDate(movie.getReleaseDate()));
        txtOverview.setText(movie.getOverview());
        txtLanguage.setText(movie.getOriginalLanguage());
        txtReleaseDate.setText(movie.getReleaseDate());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
