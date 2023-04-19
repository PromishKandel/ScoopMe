package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.scoopme.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class RequestActivity extends AppCompatActivity implements MapsAPI.Geo {

    private Button submit, home;
    private EditText startpoint, destination;

    private ArrayList<JSONExtractor> result = new ArrayList();
    private int x;

    Timer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        submit = (Button) findViewById(R.id.REsubmit_btn);
        startpoint = (EditText) findViewById(R.id.REstart_location_text);
        destination = (EditText) findViewById(R.id.REDestination_text);
        timer = new Timer();

        home = (Button) findViewById(R.id.ReqHomePagebtn);


        Dispatcher dispatcher = new Dispatcher();
        OfferEntity oe = new OfferEntity(RequestActivity.this);

        String Name = getIntent().getStringExtra("Name");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                intent.putExtra("HomeProfileName",Name);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String start = startpoint.getText().toString();
                String des = destination.getText().toString();
                ArrayList<OfferEntityModel> ar = oe.readUser();
                ArrayList<Matchmodel> matches = dispatcher.matches(des,ar);
                x = matches.size();



                for(int i = 0; i<matches.size(); i++){
                        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                        matches.get(i).getStartpoint() + "&destinations=" + start
                        + "&mode=driving&language=fr-FR&avoid=tolls&key=AIzaSyDuZ8vMARj5LAvusOAY18VhUjearngC0WY";
                        new MapsAPI(RequestActivity.this).execute(url);
                }

                String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                        start + "&destinations=" + matches.get(0).getDestination()
                        + "&mode=driving&language=fr-FR&avoid=tolls&key=AIzaSyDuZ8vMARj5LAvusOAY18VhUjearngC0WY";
                new MapsAPI(RequestActivity.this).execute(url);

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println(result.get(1).getTime());
                        Intent intent = new Intent(getApplicationContext(),SelectAnOfferActivity.class);
                        intent.putExtra("matches", matches);
                        intent.putExtra("start",start);
                        intent.putExtra("time",result);
                        startActivity(intent);
                    }
                },10000);
            }
        });

    }

    public void setDouble(String result) {
        String res[]=result.split(",");
        double min=Double.parseDouble(res[0])/60;
        double dist=Integer.parseInt(res[1])/1000;
        this.result.add(new JSONExtractor(min,dist));
    }
}