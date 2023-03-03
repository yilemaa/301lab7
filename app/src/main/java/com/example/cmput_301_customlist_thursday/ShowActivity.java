package com.example.cmput_301_customlist_thursday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.time.temporal.ValueRange;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        String cityName = getIntent().getStringExtra("cityName");
        Log.d("Value", "cityName is "+cityName);
        TextView cityText = findViewById(R.id.textView);
        cityText.setText(cityName);
        // get the button and add a listener to it
        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(v -> {
            // go back to MainActivity
            finish();
        });
    }
}