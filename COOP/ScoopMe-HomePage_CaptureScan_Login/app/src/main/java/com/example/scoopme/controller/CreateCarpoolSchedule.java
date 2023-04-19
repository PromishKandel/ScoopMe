package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoopme.R;

import java.util.ArrayList;

public class CreateCarpoolSchedule extends AppCompatActivity {


    private EditText start, des, time, days;
    private Button submit, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_carpool_schedule);

        start = (EditText) findViewById(R.id.start_location_text);
        des = (EditText) findViewById(R.id.Destination_text);
        time = (EditText) findViewById(R.id.pickupTime_text);
        days = (EditText) findViewById(R.id.Days_text);

        submit = (Button) findViewById(R.id.submit_btn);
        home = (Button) findViewById(R.id.CreateCarpoolHomePagebtn);

        String Name = getIntent().getStringExtra("Name");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] info = {start.getText().toString(), des.getText().toString(), time.getText().toString(),days.getText().toString()};
                if((start.getText().toString().isEmpty()) || (des.getText().toString().isEmpty()) || (time.getText().toString().isEmpty()) || (days.getText().toString().isEmpty())){
                    Toast.makeText(CreateCarpoolSchedule.this, "All Fields must be filled", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(),CarpoolScheduleActivity.class);
                    intent.putExtra("Scheuduleinfo",info);
                    startActivity(intent);
                }
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                intent.putExtra("HomeProfileName",Name);
                startActivity(intent);
            }
        });


    }
}