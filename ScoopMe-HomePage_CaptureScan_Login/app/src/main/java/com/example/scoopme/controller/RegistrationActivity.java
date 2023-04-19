package com.example.scoopme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoopme.R;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    EditText FirstName, LastName, UserName, Password;
    Button btnRegister, btnLogin;
    CheckBox CBTOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        LoginController LC = new LoginController();

        FirstName = (EditText) findViewById(R.id.RegFirstName);
        LastName = (EditText) findViewById(R.id.RegLastName);
        UserName = (EditText) findViewById(R.id.RegUsername);
        Password = (EditText) findViewById(R.id.RegPassword);

        btnRegister = (Button) findViewById(R.id.Regbutton);
        btnLogin = (Button) findViewById(R.id.RegLoginbtn);

        CBTOS = (CheckBox) findViewById(R.id.RegTOS);

        UserEntity ue = new UserEntity(RegistrationActivity.this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                //Getting values from user registration
                String[] RegisterInfo = {FirstName.getText().toString(), LastName.getText().toString(), UserName.getText().toString(), Password.getText().toString()};

                //Checking is everything is filled in including TOS
                if (!CBTOS.isChecked()) {
                    Toast.makeText(RegistrationActivity.this, "You must agree to the TOS", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(FirstName.getText().toString())) {
                    FirstName.setError("This item cannot be empty");

                } else if (TextUtils.isEmpty(LastName.getText().toString())) {
                    LastName.setError(("This item cannot be empty"));
                } else if (TextUtils.isEmpty(UserName.getText().toString())) {
                    UserName.setError(("This item cannot be empty"));
                } else if (TextUtils.isEmpty(Password.getText().toString())){
                    Password.setError(("This item cannot be empty"));
                } else{

                    //Reading values from database and storing to an arraylist
                    ArrayList<UserEntityModel> ar = ue.readUser();

                    //Checinking to see
                    if (LC.verifyRegistration(RegisterInfo,ar) == true){

                        //Adds to the database
                        ue.addUser(RegisterInfo[0],RegisterInfo[1],RegisterInfo[2],RegisterInfo[3]);
                        Toast.makeText(RegistrationActivity.this, "User has been added", Toast.LENGTH_SHORT).show();

//                        Goes back to the Loginpage
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        OpenNewPage(intent);
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private void OpenNewPage(Intent intent){
        startActivity(intent);
    }

}