
package com.sjani.filterrecyclerviewapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pizza {

    @SerializedName("Chef's Choice")
    @Expose
    private List<PizzaItem> chefSChoice = null;
    @SerializedName("Classics")
    @Expose
    private List<PizzaItem> classics = null;
    @SerializedName("Signature")
    @Expose
    private List<PizzaItem> signature = null;
    @SerializedName("Vegetarian")
    @Expose
    private List<PizzaItem> vegetarian = null;

    public List<PizzaItem> getChefSChoice() {
        return chefSChoice;
    }

    public void setChefSChoice(List<PizzaItem> chefSChoice) {
        this.chefSChoice = chefSChoice;
    }

    public List<PizzaItem> getClassics() {
        return classics;
    }

    public void setClassics(List<PizzaItem> classics) {
        this.classics = classics;
    }

    public List<PizzaItem> getSignature() {
        return signature;
    }

    public void setSignature(List<PizzaItem> signature) {
        this.signature = signature;
    }

    public List<PizzaItem> getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(List<PizzaItem> vegetarian) {
        this.vegetarian = vegetarian;
    }



}
