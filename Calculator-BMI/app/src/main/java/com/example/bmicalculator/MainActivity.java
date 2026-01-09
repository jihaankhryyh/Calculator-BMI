package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ageInput, heightInput, weightInput;
    private RadioGroup genderGroup;
    private RadioButton selectedGender;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageInput = findViewById(R.id.ageInput);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        genderGroup = findViewById(R.id.genderGroup);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageStr = ageInput.getText().toString();
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (!ageStr.isEmpty() && !heightStr.isEmpty() && !weightStr.isEmpty()) {
            double height = Double.parseDouble(heightStr) / 100;
            double weight = Double.parseDouble(weightStr);
            double bmi = weight / (height * height);

            int selectedId = genderGroup.getCheckedRadioButtonId();
            selectedGender = findViewById(selectedId);
            String gender = selectedGender == null ? "Unknown" : selectedGender.getText().toString();

            Intent intent = new Intent(MainActivity.this, ResultMainActivity.class);
            intent.putExtra("BMI", bmi);
            intent.putExtra("GENDER", gender);
            startActivity(intent);
        } else {
            resultText.setText("Please fill in all fields.");
        }
    }
}