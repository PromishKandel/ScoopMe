package com.example.scoopme.controller;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoopme.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScannerActivity extends AppCompatActivity {

    private EditText code;
    private Button submit, scan, home;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        code = (EditText) findViewById(R.id.ScaCode);
        submit = (Button) findViewById(R.id.ScaCodebtn);
        scan = (Button) findViewById(R.id.ScaQRCodebtn);
        home = (Button) findViewById(R.id.ScaHome);
        String Name = getIntent().getStringExtra("Name");
        this.name = Name;



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code.getText().toString().equals("valid")) {
                    Intent intent = new Intent(getApplicationContext(), OfferActivity.class);
                    intent.putExtra("Name", Name);
                    OpenNewPage(intent);
                } else {
                    System.out.println(code.getText().toString());
                    Toast.makeText(ScannerActivity.this, "Please enter/scan a QR code", Toast.LENGTH_SHORT).show();
                }
            }
        });






        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
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

    private void scanCode(){
        ScanOptions options = new ScanOptions();
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
    {
        if(result.getContents().equals("valid")){
            Intent intent = new Intent(getApplicationContext(), OfferActivity.class);
            intent.putExtra("Name",this.name);
            OpenNewPage(intent);
        }

    });
    private void OpenNewPage(Intent intent){
        startActivity(intent);
    }
}
