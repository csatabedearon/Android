package com.example.fel2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputProductCode, inputProductName, inputProductPrice;
    private TextView productList;
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputProductCode = findViewById(R.id.inputProductCode);
        inputProductName = findViewById(R.id.inputProductName);
        inputProductPrice = findViewById(R.id.inputProductPrice);
        productList = findViewById(R.id.productList);

        Button addProductButton = findViewById(R.id.addProductButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button showProductsButton = findViewById(R.id.showProductsButton);

        products = new ArrayList<>();

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = inputProductCode.getText().toString();
                String name = inputProductName.getText().toString();
                String price = inputProductPrice.getText().toString();

                if (!code.isEmpty() && !name.isEmpty() && !price.isEmpty()) {
                    products.add(new Product(code, name, Double.parseDouble(price)));
                    inputProductCode.setText("");
                    inputProductName.setText("");
                    inputProductPrice.setText("");
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputProductCode.setText("");
                inputProductName.setText("");
                inputProductPrice.setText("");
            }
        });

        showProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for (Product product : products) {
                    sb.append(product).append("\n");
                }
                productList.setText(sb.toString());
            }
        });
    }

    static class Product {
        private String code;
        private String name;
        private double price;

        public Product(String code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Code: " + code + ", Name: " + name + ", Price: " + price;
        }
    }
}
