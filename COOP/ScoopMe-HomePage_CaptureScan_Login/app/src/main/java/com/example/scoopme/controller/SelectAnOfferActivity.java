package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scoopme.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectAnOfferActivity extends AppCompatActivity {

    private CheckBox op1,op2,op3;
    private TextView op1view, op2view, op3view;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_an_offer);

        op1 = (CheckBox) findViewById(R.id.Op1);
        op2 = (CheckBox) findViewById(R.id.Op2);
        op3 = (CheckBox) findViewById(R.id.Op3);
        op1view = (TextView) findViewById(R.id.Op1view);
        op2view = (TextView) findViewById(R.id.Op2view);
        op3view = (TextView) findViewById(R.id.Op3view);
        submit = (Button) findViewById(R.id.SelectSubmit);

        ArrayList<Matchmodel> matches = (ArrayList<Matchmodel>) getIntent().getSerializableExtra("matches");
        String startposition = getIntent().getStringExtra("start");
        ArrayList<JSONExtractor> timer = (ArrayList<JSONExtractor>) getIntent().getSerializableExtra("time");


        if(matches.size()==0){
            Intent intent = new Intent(getApplicationContext(),RequestActivity.class);
            Toast.makeText(SelectAnOfferActivity.this, "No matches found", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }


        if (matches.size() == 1){
            op1view.setText(startposition + " \n" + matches.get(0).getDestination() + " \nArrives in(minutes): " + timer.get(0).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));

            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",0);
                    startActivity(intent);
                }
            });

        }else if (matches.size() == 2){
            op1view.setText(startposition + " \n" + matches.get(0).getDestination() + " \nArrives in(minutes): " + timer.get(0).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));
            op2view.setText(startposition + " \n" + matches.get(1).getDestination() + " \nArrives in(minutes): " + timer.get(1).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));

            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",0);
                    startActivity(intent);
                }
            });


            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",1);
                    startActivity(intent);

                }
            });


        }else if (matches.size() == 3){
            op1view.setText(startposition + " \n" + matches.get(0).getDestination() + " \nArrives in(minutes): " + timer.get(0).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));
            op2view.setText(startposition + " \n" + matches.get(1).getDestination() + " \nArrives in(minutes): " + timer.get(1).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));
            op3view.setText(startposition + " \n" + matches.get(2).getDestination() + " \nArrives in(minutes): " + timer.get(2).getTime()
                    + "\nCost: " + cost(timer.get(timer.size()-1).getDistance()));

            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",0);
                    startActivity(intent);
                }
            });


            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",1);
                    startActivity(intent);

                }
            });

            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AcceptOffer.class);
                    intent.putExtra("matches",matches);
                    intent.putExtra("start",startposition);
                    intent.putExtra("timer",timer);
                    intent.putExtra("key",2);
                    startActivity(intent);
                }
            });
        }

    }


    private String cost(double distance){
        return Double.toString(0.5*distance);
    }
}