package com.example.fragmentcodeapp2023;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Context context = getActivity().getApplicationContext();

        final String[] currencies = {
                "EUR - Cumpără: 4,4100 RON, Vinde: 4,5500 RON",
                "USD - Cumpără: 3,9750 RON, Vinde: 4,1450 RON",
                "GBP - Cumpără: 6,1250 RON, Vinde: 6,3550 RON",
                "AUD - Cumpără: 2,9600 RON, Vinde: 3,0600 RON",
                "CAD - Cumpără: 3,0950 RON, Vinde: 3,2650 RON",
                "CHF - Cumpără: 4,2300 RON, Vinde: 4,3300 RON",
                "DKK - Cumpără: 0,5850 RON, Vinde: 0,6150 RON",
                "HUF - Cumpără: 0,0136 RON, Vinde: 0,0146 RON"
        };

        ListView currencyList = view.findViewById(R.id.fruits_list);
        CurrencyAdapter adapter = new CurrencyAdapter(context, currencies);
        currencyList.setAdapter(adapter);

        currencyList.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getActivity(), ShowItemActivity.class);
            intent.putExtra("currency", currencies[position]);
            startActivity(intent);
        });

        return view;
    }
}
