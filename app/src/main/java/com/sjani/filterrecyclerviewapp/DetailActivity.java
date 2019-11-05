package com.sjani.filterrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String POSITION = "position";

    @BindView(R.id.details_name)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra(POSITION,0);
        String name = intent.getExtras().getString(NAME);
        textView.setText(name);
    }
}
