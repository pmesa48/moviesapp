package com.android.pmesa.moviesapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pmesa.moviesapp.R;
import com.android.pmesa.moviesapp.common.Utils;
import com.android.pmesa.moviesapp.model.entities.Result;
import com.android.pmesa.moviesapp.ui.MovieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pablomesa on 6/03/16.
 */
public class MovieAdapter extends ArrayAdapter<Result> {
    public static final String BASE_URL = "http://image.tmdb.org/t/p";
    List<Result> movies;
    Context context;
    public MovieAdapter(Context context, int resource, List<Result> objects) {
        super(context, resource, objects);
        this.movies = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final Result result = movies.get(position);
        if( convertView == null ){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.movie_item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgMovie = (ImageView)convertView.findViewById(R.id.movie_image);
            viewHolder.imgMovie.setImageDrawable(context.getDrawable(R.drawable.place_holder));

            viewHolder.txtName = (TextView)convertView.findViewById(R.id.movie_title);
            viewHolder.txtYear = (TextView)convertView.findViewById(R.id.movie_year);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(result != null){
            viewHolder.txtName.setText(result.getOriginalTitle());
            viewHolder.txtYear.setText(Utils.getYearFromDate(result.getReleaseDate()));
            Picasso.with(context)
                    .load(BASE_URL + "/w300" + result.getPosterPath())
                    .into(viewHolder.imgMovie);
        }

        return convertView;
    }



    static class ViewHolder{
        ImageView imgMovie;
        TextView txtYear;
        TextView txtName;
    }
}
