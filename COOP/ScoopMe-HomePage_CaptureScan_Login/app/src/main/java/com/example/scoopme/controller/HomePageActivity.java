package com.example.scoopme.controller;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.scoopme.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class HomePageActivity extends AppCompatActivity {
    Button btnRequest, btnOfferride,btnschedulecarpool, btnSetting, btnlogout;


    TextView Profilename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        btnschedulecarpool = (Button) findViewById(R.id.HomebtnSchedule);
        btnRequest = (Button) findViewById(R.id.HomebtnRequestRide);
        btnOfferride = (Button) findViewById(R.id.HomebtnOfferRide);
        btnSetting = (Button) findViewById(R.id.HomebtnSettings);
        btnlogout = (Button) findViewById(R.id.Logout);
        Profilename = (TextView) findViewById(R.id.HomeProfileName);
        String Name = getIntent().getStringExtra("HomeProfileName");
        String oldpassword = getIntent().getStringExtra("Password");
        Profilename.setText(Name);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                OpenNewPage(intent);
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when Request is clicked
                Intent intent = new Intent(getApplicationContext(),RequestActivity.class);
                intent.putExtra("Name",Name);
                OpenNewPage(intent);
            }
        });

        btnOfferride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScannerActivity.class);
                intent.putExtra("Name", Name);
                OpenNewPage(intent);
            }
        });
        btnschedulecarpool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when schedulecarpool is clicked
                Intent intent = new Intent(getApplicationContext(), CarpoolScheduleActivity.class);
                intent.putExtra("Name",Name);
                OpenNewPage(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                intent.putExtra("oldusername",Name);
                intent.putExtra("oldpassword",oldpassword);
                OpenNewPage(intent);
            }
        });
    }
    private void OpenNewPage(Intent intent){
        startActivity(intent);
    }
}