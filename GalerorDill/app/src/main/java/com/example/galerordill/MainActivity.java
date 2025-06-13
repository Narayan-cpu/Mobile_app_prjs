package com.example.galerordill;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     Button gall,dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        dial=findViewById(R.id.button);
        gall=findViewById(R.id.button2);
        dial.setOnClickListener(v->{
            Intent dialIn=new Intent(Intent.ACTION_DIAL);
            dialIn.setData(Uri.parse("tel:"));
            startActivity(dialIn);
        });
        gall.setOnClickListener(v->{
            Intent gal=new Intent();
            gal.setAction(Intent.ACTION_VIEW);
            gal.setData(Uri.parse("content://media/external/images/media/"));
            startActivity(gal);

        });
    }
}