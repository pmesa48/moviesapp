package com.android.pmesa.moviesapp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pablomesa on 6/03/16.
 */
public class Dates {

    @SerializedName("minimum")
    @Expose
    private String minimum;
    @SerializedName("maximum")
    @Expose
    private String maximum;

    /**
     *
     * @return
     * The minimum
     */
    public String getMinimum() {
        return minimum;
    }

    /**
     *
     * @param minimum
     * The minimum
     */
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    /**
     *
     * @return
     * The maximum
     */
    public String getMaximum() {
        return maximum;
    }

    /**
     *
     * @param maximum
     * The maximum
     */
    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

}
