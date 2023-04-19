package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.scoopme.R;

public class RatingActivity extends AppCompatActivity {

    private RatingBar r;
    private Button trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        r = (RatingBar) findViewById(R.id.ratingBar);
        trip = (Button) findViewById(R.id.ratebtn);

        trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r.getRating();
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
            }
        });


    }
}