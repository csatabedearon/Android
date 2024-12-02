package com.example.fragmentcodeapp2023;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CurrencyAdapter extends ArrayAdapter<String> {
    public CurrencyAdapter(Context context, String[] currencies) {
        super(context, android.R.layout.simple_list_item_2, android.R.id.text1, currencies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView text1 = view.findViewById(android.R.id.text1);

        String item = getItem(position);
        String[] parts = item.split(", ");

        if (parts.length >= 3) {
            text1.setText(parts[0] + "\n" + parts[1] + " | " + parts[2]);
        } else {
            text1.setText(item);
        }

        return view;
    }

}
