package com.android.pmesa.moviesapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.pmesa.moviesapp.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
