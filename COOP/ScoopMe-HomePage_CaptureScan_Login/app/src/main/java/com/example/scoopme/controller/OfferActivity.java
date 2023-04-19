package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoopme.R;

public class OfferActivity extends AppCompatActivity {


    private Button submit, home;
    private EditText startpoint, destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        submit = (Button) findViewById(R.id.OFsubmit_btn);
        home = (Button) findViewById(R.id.OfferHomePagebtn);
        startpoint = (EditText) findViewById(R.id.OFstart_location_text);
        destination = (EditText) findViewById(R.id.OFDestination_text);
        String Name = getIntent().getStringExtra("Name");

        OfferEntity oe = new OfferEntity(OfferActivity.this);

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
                if ((startpoint.getText().toString().isEmpty()) || (destination.getText().toString().isEmpty())){
                    Toast.makeText(OfferActivity.this, "All Fields must be filled", Toast.LENGTH_SHORT).show();
                }else{
                    oe.addoffer(startpoint.getText().toString(),destination.getText().toString());
                    Toast.makeText(OfferActivity.this, "Offer has been added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                    intent.putExtra("HomeProfileName",Name);
                    startActivity(intent);
                }
            }
        });






    }
}