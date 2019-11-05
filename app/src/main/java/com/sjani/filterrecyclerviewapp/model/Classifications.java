
package com.sjani.filterrecyclerviewapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Classifications {

    @SerializedName("vegetarian")
    @Expose
    private Boolean vegetarian;
    @SerializedName("gluten_free")
    @Expose
    private Boolean glutenFree;

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    public String toString() {
        return "Classifications{" +
                "vegetarian=" + vegetarian +
                ", glutenFree=" + glutenFree +
                '}';
    }
}
