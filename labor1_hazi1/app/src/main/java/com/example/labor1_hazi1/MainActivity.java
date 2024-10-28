package com.example.labor1_hazi1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        setButtonListeners();
    }

    private void initializeViews() {
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);
    }

    private void setButtonListeners() {
        findViewById(R.id.osszeadas).setOnClickListener(v -> calculateAndDisplayResult(Operation.ADD));
        findViewById(R.id.kivonas).setOnClickListener(v -> calculateAndDisplayResult(Operation.SUBTRACT));
        findViewById(R.id.szorzas).setOnClickListener(v -> calculateAndDisplayResult(Operation.MULTIPLY));
        findViewById(R.id.osztas).setOnClickListener(v -> calculateAndDisplayResult(Operation.DIVIDE));
    }

    private void calculateAndDisplayResult(Operation operation) {
        try {
            float num1 = Float.parseFloat(number1.getText().toString());
            float num2 = Float.parseFloat(number2.getText().toString());
            float resultValue;

            switch (operation) {
                case ADD:
                    resultValue = num1 + num2;
                    break;
                case SUBTRACT:
                    resultValue = num1 - num2;
                    break;
                case MULTIPLY:
                    resultValue = num1 * num2;
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        result.setText("Cannot divide by zero");
                        return;
                    }
                    resultValue = num1 / num2;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
            result.setText(String.valueOf(resultValue));
        } catch (NumberFormatException e) {
            result.setText("Invalid input");
        }
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
