package com.example.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends BaseAdapter {
    private Context context;
    private List<Currency> currencyList;

    public CurrencyAdapter(Context context, List<Currency> currencyList) {
        this.context = context;
        this.currencyList = currencyList;
    }

    @Override
    public int getCount() {
        return currencyList.size();
    }

    @Override
    public Object getItem(int position) {
        return currencyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Currency currency = currencyList.get(position);

        ImageView flagImage = convertView.findViewById(R.id.flagImage);
        TextView currencyCode = convertView.findViewById(R.id.currencyCode);
        TextView currencyName = convertView.findViewById(R.id.currencyName);
        TextView buyRate = convertView.findViewById(R.id.buyRate);
        TextView sellRate = convertView.findViewById(R.id.sellRate);

        flagImage.setImageResource(currency.getFlagImage());
        currencyCode.setText(currency.getCode());
        currencyName.setText(currency.getName());
        buyRate.setText("Cumpara " + currency.getBuyRate());
        sellRate.setText("Vinde " + currency.getSellRate());

        return convertView;
    }
}
