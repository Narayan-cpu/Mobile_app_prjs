package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AttractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_attraction);
        ListView lv1=findViewById(R.id.list);
        String attr[]={"Musium","Temple","park"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,attr);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AttractionActivity.this,Webpage.class);
            startActivity(intent);
        });

    }
}