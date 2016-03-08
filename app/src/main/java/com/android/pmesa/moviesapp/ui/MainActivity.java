package com.android.pmesa.moviesapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.pmesa.moviesapp.R;
import com.android.pmesa.moviesapp.common.Utils;
import com.android.pmesa.moviesapp.model.entities.Result;
import com.android.pmesa.moviesapp.ui.adapter.MovieAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private final static String[] OPTIONS = new String[]{"Popularity","Upcoming"};
    GridView moviesGrid;
    MovieAdapter adapter;
    MainPresenter presenter;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesGrid = (GridView)findViewById(R.id.movies_grid);
        spinner = (Spinner)findViewById(R.id.spinner_sort);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, OPTIONS);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String option = OPTIONS[position];
                if(option.equals("Popularity")){
                    presenter.fetchPopularMovies(Utils.TMBD_KEY,1);
                } else if(option.equals("Upcoming")){
                    presenter.fetchUpcomingMovies(Utils.TMBD_KEY,1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        presenter = new MainPresenter(this);
    }

    @Override
    public void renderPopularMovies(final List<Result> movies) {
        adapter = new MovieAdapter(this, R.layout.movie_item_layout, movies);
        moviesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MovieActivity.class);
                i.putExtra("movie", movies.get(position));
                startActivity(i);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moviesGrid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onError() {
        Log.d("MainActivity", "Error");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"You may not have internet access",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public Context getContext() {
        return getContext();
    }
}
