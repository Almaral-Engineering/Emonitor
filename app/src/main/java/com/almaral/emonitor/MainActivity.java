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

        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hola");
        arrayList.add("Adios");
        arrayList.add("Como");
        arrayList.add("Estás");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
    }
}
