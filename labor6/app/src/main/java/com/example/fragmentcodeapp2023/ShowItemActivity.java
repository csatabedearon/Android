package com.example.fragmentcodeapp2023;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedCurrency = extras.getString("currency");
            TextView textView = findViewById(R.id.selectedopt);
            textView.setText(selectedCurrency);
        }
    }
}
