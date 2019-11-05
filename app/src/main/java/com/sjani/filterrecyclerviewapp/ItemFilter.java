package com.sjani.filterrecyclerviewapp;

import android.util.Log;

import com.sjani.filterrecyclerviewapp.model.PizzaItem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ItemFilter {

    public static final String TAG = ItemFilter.class.getSimpleName();

    private Set<Allergen> currentAllergen = new HashSet<>();
    private List<PizzaItem> filteredList = new LinkedList<>();

    public List<PizzaItem> filterResults(List<PizzaItem> pizzaItems, Allergen allergen, boolean remove) {
        if (remove) {
            currentAllergen.remove(allergen);
        } else {
            currentAllergen.add(allergen);
        }

        for (PizzaItem item : pizzaItems) {
            filteredList.add(item);
        }
        for (PizzaItem item : filteredList) {
            if (currentAllergen.contains(allergen)) {
                if (allergen.equals(Allergen.GLUTEN) && (item.getClassifications().getGlutenFree() == null || !item.getClassifications().getGlutenFree())) {
                    Log.e(TAG, "filterResults: HERE 2 \n" + item.getClassifications().getGlutenFree());
                    filteredList.remove(item);
                }
                if (allergen.equals(Allergen.VEGETARIAN) && (item.getClassifications().getVegetarian() == null || !item.getClassifications().getVegetarian())) {
                    Log.e(TAG, "filterResults: HERE 3 \n" + item.getClassifications().getVegetarian());
                    filteredList.remove(item);
                }
            }
        }
        return filteredList;
    }

}
