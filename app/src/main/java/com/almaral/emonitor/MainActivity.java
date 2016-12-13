package com.almaral.emonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView earthquakeListView = (ListView) findViewById(R.id.earthquake_list_view);
        ArrayList<String> countriesList = new ArrayList<>();

        countriesList.add("México");
        countriesList.add("Venezuela");
        countriesList.add("Colombia");
        countriesList.add("España");
        countriesList.add("Perú");

        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countriesList);
        earthquakeListView.setAdapter(countriesAdapter);
    }
}
