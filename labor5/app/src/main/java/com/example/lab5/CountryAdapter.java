package com.example.lab5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class CountryAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> countries;
    private Map<Integer, Integer> colorMap;

    public CountryAdapter(Context context, List<String> countries, Map<Integer, Integer> colorMap) {
        super(context, R.layout.list_item, countries);
        this.context = context;
        this.countries = countries;
        this.colorMap = colorMap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.countryTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(countries.get(position));

        if (colorMap.containsKey(position)) {
            holder.textView.setTextColor(colorMap.get(position));
        } else {
            holder.textView.setTextColor(Color.BLACK);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}
