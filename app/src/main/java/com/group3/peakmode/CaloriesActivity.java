package com.group3.peakmode;


import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriesActivity extends AppCompatActivity {
    private int totalCalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        EditText etCalories = findViewById(R.id.etCalories);
        Button btnAdd = findViewById(R.id.btnAddCalories);
        TextView tvTotal = findViewById(R.id.tvTotalCalories);

        btnAdd.setOnClickListener(v -> {
            String input = etCalories.getText().toString();
            if (!input.isEmpty()) {
                int calories = Integer.parseInt(input);
                if (calories > 0) {
                    totalCalories += calories;
                    tvTotal.setText("Your Total Calories: " + totalCalories);
                    etCalories.setText("");
                } else {
                    Toast.makeText(this, "Enter a positive number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}