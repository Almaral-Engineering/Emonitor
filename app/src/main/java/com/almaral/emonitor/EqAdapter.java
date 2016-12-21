package com.almaral.emonitor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EqAdapter extends ArrayAdapter<Earthquake> {
    private ArrayList<Earthquake> eqList;
    private Context context;
    private int layoutId;

    public EqAdapter(Context context, int resource, List<Earthquake> earthquakes) {
        super(context, resource, earthquakes);

        this.context = context;
        this.layoutId = resource;
        eqList = new ArrayList<>(earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layoutId, null);

            holder = new ViewHolder();
            holder.magnitudeTextView = (TextView) convertView.findViewById(R.id.eq_list_item_magnitude);
            holder.placeTextView = (TextView) convertView.findViewById(R.id.eq_list_item_place);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Earthquake earthquake = eqList.get(position);

        holder.magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));
        holder.placeTextView.setText(earthquake.getPlace());

        return convertView;
    }

    private class ViewHolder {
        public TextView magnitudeTextView;
        public TextView placeTextView;
    }
}
