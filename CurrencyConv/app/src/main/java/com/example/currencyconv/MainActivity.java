package com.example.currencyconv;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerfrom,spinnerTo;
    EditText e1;
    TextView tv1;
    Button conv;
    HashMap<String,Double> exc=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinnerfrom=findViewById(R.id.spinner2);
        spinnerTo=findViewById(R.id.spinner3);
        e1=findViewById(R.id.amount);
        tv1=findViewById(R.id.textView2);
        conv=findViewById(R.id.button);
        SetUpExRate();
        String[] curr={"USD", "EUR", "GBP", "INR", "JPY"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,curr);
        spinnerfrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
        conv.setOnClickListener(v->Convert());

    }
    public void SetUpExRate(){
        exc.put("USD", 1.0);
        exc.put("EUR", 0.92);
        exc.put("GBP", 0.78);
        exc.put("INR", 82.5);
        exc.put("JPY", 132.0);
    }
    public void Convert(){
        String fromCurr=spinnerfrom.getSelectedItem().toString();
        String tocurr=spinnerTo.getSelectedItem().toString();
        String amt=e1.getText().toString();
        if(amt.isEmpty()){
            Toast.makeText(this,"Enter the amount",Toast.LENGTH_SHORT).show();
            return;
        }
        double a=Double.parseDouble(amt);
        double exf=exc.get(fromCurr);
        double ext=exc.get(tocurr);
        double res=a/exf*ext;
        tv1.setText("Eonv of "+fromCurr+" to "+tocurr+" is "+res);

    }
}