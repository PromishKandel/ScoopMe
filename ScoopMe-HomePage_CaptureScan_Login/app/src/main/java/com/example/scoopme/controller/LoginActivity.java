package com.example.scoopme.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoopme.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity{

    private EditText loginText, passwordText;
    private Button btnLogin, btnRegister;

    private TextView txtProfilename;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginText = (EditText) findViewById(R.id.login);
        passwordText = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.loginbtn);
        btnRegister = (Button) findViewById(R.id.Registerbtn);

        LoginController LC = new LoginController();
        UserEntity ue = new UserEntity(LoginActivity.this);

        //Login button click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Arraylist of database data
                ArrayList<UserEntityModel> ar = ue.readUser();

                //Controller checks if the login is valid
                boolean valid = LC.verifyLogin(loginText.getText().toString(),passwordText.getText().toString(),ar);


                if (valid == true){
                    if (LC.DisplayHomepage()){
                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        intent.putExtra("HomeProfileName",getUsername());
                        intent.putExtra("Password",getPassword());
                        intent.putExtra("start",getUsername());
                        intent.putExtra("end",getPassword());
                        intent.putExtra("time",getUsername());
                        intent.putExtra("day",getPassword());
                        OpenNewPage(intent);
                    }


                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Register button click
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LC.DisplayRegistration() == true){
                    Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    OpenNewPage(intent);
                }
            }
        });

    }


    public String getUsername(){
        return loginText.getText().toString();
    }
    public String getPassword(){
        return passwordText.getText().toString();
    }
    private void OpenNewPage(Intent intent){
        startActivity(intent);
    }
}

