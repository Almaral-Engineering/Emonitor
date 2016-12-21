package com.almaral.emonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DownloadEqsAsyncTask.DownloadEqsInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView earthquakeListView = (ListView) findViewById(R.id.earthquake_list_view);
        ArrayList<Earthquake> eqList = new ArrayList<>();

        eqList.add(new Earthquake("4.6", "97 km S of Wonosari, Indonesia"));
        eqList.add(new Earthquake("2.3", "16 km S of Joshua Tree, CA"));
        eqList.add(new Earthquake("3.1", "97 km S of Wonosari, Indonesia"));

        EqAdapter eqAdapter = new EqAdapter(this, R.layout.eq_list_item, eqList);
        earthquakeListView.setAdapter(eqAdapter);

        DownloadEqsAsyncTask downloadEqsAsyncTask = new DownloadEqsAsyncTask();
        downloadEqsAsyncTask.delegate = this;
        try {
            downloadEqsAsyncTask.execute(new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEqsDownloaded(String eqsData) {
    }
}
