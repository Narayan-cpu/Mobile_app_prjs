package com.example.phonedialer;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnDialer, btnGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialer = findViewById(R.id.cursor);
        btnGallery = findViewById(R.id.button2);

        // Open Dialer when button is clicked
        btnDialer.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:"));  // Opens the dialer without a number
            startActivity(dialIntent);
        });    // Open Gallery when button is clicked
        btnGallery.setOnClickListener(v -> {
            Intent i=new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://media/external/images/media/"));
            startActivity(i);

        });
    }
}