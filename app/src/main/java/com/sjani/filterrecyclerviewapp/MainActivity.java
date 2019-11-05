package com.sjani.filterrecyclerviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sjani.filterrecyclerviewapp.data.ApiConnection;
import com.sjani.filterrecyclerviewapp.model.Pizza;
import com.sjani.filterrecyclerviewapp.model.PizzaItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    public static final String TAG = MainActivity.class.getName();
    public static final String NAME = "name";
    public static final String POSITION = "position";

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.gluten_check)
    CheckBox glutenCheckBox;
    @BindView(R.id.veg_check)
    CheckBox vegCheckBox;

    LinearLayoutManager layoutManager;
    ListAdapter adapter;
    ItemFilter itemFilter;
    List<PizzaItem> pizzaItems, filteredItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new ListAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        itemFilter = new ItemFilter();
        pizzaItems = new ArrayList<>();

        ApiConnection.getApi().getPizzas().enqueue(new Callback<List<Pizza>>() {
            @Override
            public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {
                pizzaItems.addAll(response.body().get(0).getChefSChoice());
                pizzaItems.addAll(response.body().get(0).getSignature());
                pizzaItems.addAll(response.body().get(0).getClassics());
                pizzaItems.addAll(response.body().get(0).getVegetarian());

                filteredItems = new ArrayList<>(pizzaItems);
                checkboxClick(pizzaItems);
                recyclerView.setLayoutManager(layoutManager);
                adapter.swapResults(filteredItems);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<Pizza>> call, Throwable t) {

            }
        });
    }

    private void checkboxClick(List<PizzaItem> pizzaItems) {
        glutenCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                filteredItems.clear();
                filteredItems = itemFilter.filterResults(pizzaItems,Allergen.GLUTEN,!isChecked);
                adapter.swapResults(filteredItems);
            }
        });

        vegCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                filteredItems.clear();
                filteredItems = itemFilter.filterResults(pizzaItems,Allergen.VEGETARIAN,!isChecked);
                adapter.swapResults(filteredItems);
            }
        });
    }


    @Override
    public void itemClick(int position, String name) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NAME, name);
        intent.putExtra(POSITION, position);
        startActivity(intent);
    }
}
