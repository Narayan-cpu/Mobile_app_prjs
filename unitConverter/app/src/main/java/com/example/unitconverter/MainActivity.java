package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button convertButton;
    private TextView resultTextView;
    private EditText valueEditText;  // Add an EditText for input

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rg);
        convertButton = findViewById(R.id.b1);
        resultTextView = findViewById(R.id.tv2);
        valueEditText = findViewById(R.id.valueEditText);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        if (valueEditText == null) {
            resultTextView.setText("Please add an EditText with id valueEditText for input");
            return;
        }
        String inputValueStr = valueEditText.getText().toString();
        if (inputValueStr.isEmpty()) {
            resultTextView.setText("Please enter a value.");
            return;
        }
        double inputValue;
        try {
            inputValue = Double.parseDouble(inputValueStr);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a number.");
            return;
        }

        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        if (selectedRadioButton != null) {
            String conversion = selectedRadioButton.getText().toString();
            double result = 0;

            switch (conversion) {
                case "km to m":
                    result = inputValue * 1000;
                    break;
                case "m to km":
                    result = inputValue / 1000;
                    break;
                case "m to cm ":
                    result = inputValue * 100;
                    break;
                case "cm to m":
                    result = inputValue / 100;
                    break;
            }

            resultTextView.setText(String.format("%.2f", result)); // Format to 2 decimal places
        } else {
            resultTextView.setText("Please select a conversion.");
        }
    }
}