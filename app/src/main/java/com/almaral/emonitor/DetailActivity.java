package com.almaral.emonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView eqDetailTextView = (TextView) findViewById(R.id.eq_detail_text_view);

        Bundle extras = getIntent().getExtras();
        Earthquake earthquake = extras.getParcelable(MainActivity.SELECTED_EARTHQUAKE);

        if (earthquake != null) {
            eqDetailTextView.setText(earthquake.getDateTime() +
                    "\nMag: " + earthquake.getMagnitude() +
                    "\nPlace : " + earthquake.getPlace() +
                    "\nLon: " + earthquake.getLongitude() +
                    "\nLat: " + earthquake.getLatitude());
        }
    }
}
