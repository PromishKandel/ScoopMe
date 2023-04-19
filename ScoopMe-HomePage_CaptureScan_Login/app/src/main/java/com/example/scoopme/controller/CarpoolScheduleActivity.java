package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scoopme.R;

import org.w3c.dom.Text;

public class CarpoolScheduleActivity extends AppCompatActivity {

    private TextView start, des, time, days;
    private Button update, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpool_schedule);

        start = (TextView) findViewById(R.id.CsheStartpoint);
        des = (TextView) findViewById(R.id.CsheDestination);
        time = (TextView) findViewById(R.id.CsheTime);
        days = (TextView) findViewById(R.id.CsheDays);

        update = (Button) findViewById(R.id.CsheUpdatebtn);
        home = (Button) findViewById(R.id.CarpoolHomePagebtn);

        String Name = getIntent().getStringExtra("Name");

        if (getIntent().hasExtra("Scheuduleinfo")){
            String[] info = getIntent().getStringArrayExtra("Scheuduleinfo");
            start.setText("Startlocation: " + info[0]);
            des.setText("Destination: " +info[1]);
            time.setText("At(Only from 7am - 12am): " + info[2]);
            days.setText("On: " + info[3]);
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateCarpoolSchedule.class);
                intent.putExtra("Name",Name);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                intent.putExtra("HomeProfileName",Name);
                intent.putExtra("start",start.getText().toString());
                intent.putExtra("end",des.getText().toString());
                intent.putExtra("time",time.getText().toString());
                intent.putExtra("day",days.getText().toString());
                startActivity(intent);
            }
        });




    }
}