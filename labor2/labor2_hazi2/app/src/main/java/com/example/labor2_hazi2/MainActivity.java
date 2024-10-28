package com.example.labor2_hazi2;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);

        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString("editTextValue", "");
            boolean isChecked = savedInstanceState.getBoolean("checkBoxValue", false);

            editText.setText(savedText);
            checkBox.setChecked(isChecked);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("editTextValue", editText.getText().toString());
        outState.putBoolean("checkBoxValue", checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String savedText = savedInstanceState.getString("editTextValue", "");
        boolean isChecked = savedInstanceState.getBoolean("checkBoxValue", false);

        editText.setText(savedText);
        checkBox.setChecked(isChecked);
    }
}
