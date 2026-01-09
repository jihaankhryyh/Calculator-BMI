package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultMainActivity extends AppCompatActivity {

    private TextView resultText, categoryText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_main);

        resultText = findViewById(R.id.resultText);
        backButton = findViewById(R.id.backButton);


        double bmi = getIntent().getDoubleExtra("BMI", 0);

        String bmiCategory = getBMICategory(bmi);

        resultText.setText(String.format("%.2f - %s", bmi, bmiCategory));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "You are underweight";
        } else if (bmi >= 25) {
            return "You are overweight";
        } else {
            return "You are a healthy weight";
        }
    }
}
