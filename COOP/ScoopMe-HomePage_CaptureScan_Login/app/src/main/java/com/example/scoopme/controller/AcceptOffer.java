package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scoopme.R;

import java.util.ArrayList;

public class AcceptOffer extends AppCompatActivity {

    private Button accept;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_offer);

        accept = (Button) findViewById(R.id.Acceptbtn);
        info = (TextView) findViewById(R.id.Acceptofferview);

        ArrayList<Matchmodel> matches = (ArrayList<Matchmodel>) getIntent().getSerializableExtra("matches");
        String startposition = getIntent().getStringExtra("start");
        ArrayList<JSONExtractor> timer = (ArrayList<JSONExtractor>) getIntent().getSerializableExtra("timer");
        int option = getIntent().getIntExtra("key",0);
        double totaltime = timer.get(option).getTime() + timer.get(timer.size()-1).getTime();
        double cost = (timer.get(option).getDistance()*0.5) + (timer.get(timer.size()-1).getDistance()*0.3);

        info.setText("Someone wants to take a ride" + "\nPickup location: "+ startposition+
                "\nPickup Time(minutes): " + timer.get(option).getTime()+
                "\nTotal Time(minutes): " + totaltime +
                "\nCost: " + cost);



        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TravellingActivity.class);
                startActivity(intent);
            }
        });


    }
}