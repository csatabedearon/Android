package com.example.lab4;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.currencyListView);

        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("EUR", "Euro", R.drawable.flag_eu, "4.4100 RON", "4.5500 RON"));
        currencyList.add(new Currency("USD", "Dolar american", R.drawable.flag_us, "3.9750 RON", "4.1450 RON"));
        currencyList.add(new Currency("GBP", "Lira sterlină", R.drawable.flag_gb, "6.1250 RON", "6.3550 RON"));
        currencyList.add(new Currency("AUD", "Dolar australian", R.drawable.flag_au, "2.9600 RON", "3.0600 RON"));
        currencyList.add(new Currency("CAD", "Dolar canadian", R.drawable.flag_ca, "3.0950 RON", "3.2650 RON"));
        currencyList.add(new Currency("CHF", "Franc elvețian", R.drawable.flag_ch, "4.2300 RON", "4.3300 RON"));
        currencyList.add(new Currency("DKK", "Coroană daneză", R.drawable.flag_dk, "0.5850 RON", "0.6150 RON"));
        currencyList.add(new Currency("HUF", "Forint maghiar", R.drawable.flag_hu, "0.0136 RON", "0.0146 RON"));


        CurrencyAdapter adapter = new CurrencyAdapter(this, currencyList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Currency selectedCurrency = currencyList.get(position);

                Toast.makeText(
                        MainActivity.this,
                        "Pénznem: " + selectedCurrency.getCode() +
                                "\nVételi ár: " + selectedCurrency.getBuyRate(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
