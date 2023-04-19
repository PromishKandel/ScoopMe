package com.example.scoopme.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoopme.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class SettingsActivity extends AppCompatActivity {
    Button UpdateUsernames, home;
    EditText UserName, Password;
    TextView Profilename;
    String oldstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);
        String oldname = getIntent().getStringExtra("oldusername");
        oldstore = oldname;
        String oldpassword = getIntent().getStringExtra("oldpassword");
        UpdateUsernames = (Button) findViewById(R.id.UpdateUsername);
        home = (Button) findViewById(R.id.SettingsHomePagebtn);
        UserEntity ue = new UserEntity(SettingsActivity.this);



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                intent.putExtra("HomeProfileName",oldstore);
                startActivity(intent);
            }
        });

        UpdateUsernames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserName = (EditText) findViewById(R.id.newUsername);
                Password = (EditText) findViewById(R.id.newPassword);
                if(!TextUtils.isEmpty(UserName.getText().toString()) || !TextUtils.isEmpty(UpdateUsernames.getText().toString())){
                    String newusername = UserName.getText().toString();
                    String newpassword = Password.getText().toString();
                    if(TextUtils.isEmpty(newusername)){
                        newusername = oldname;
                    }
                    if(TextUtils.isEmpty(newpassword)){
                        newpassword = oldpassword;
                    }
                    ue.updateUsername(newusername, newpassword, oldname, oldpassword);
                    oldstore = newusername;
                }
            }
        });

    }

    private void OpenNewPage(Intent intent){
        startActivity(intent);
    }
}