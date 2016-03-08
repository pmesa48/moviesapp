package com.android.pmesa.moviesapp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pablomesa on 6/03/16.
 */
public class Utils {
    public final static String TMBD_KEY = "ac9fd208182cbbc4f327f27f7318183f";
    public final static String DOMAIN = "http://api.themoviedb.org/3/";

    public static String getYearFromDate(String date){
        return date.substring(0,date.indexOf("-"));
    }
}
