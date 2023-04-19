package com.example.scoopme.controller;




import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.scoopme.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginController extends LoginActivity{


    private String Profilename;

    public String getProfilename(){return Profilename;}


    public boolean verifyLogin(String username, String password,ArrayList<UserEntityModel> ar){
        for(int i = 0; i < ar.size(); i++){
            if ((username.equals(ar.get(i).getUsername().trim())) && (password.equals(ar.get(i).getPassword()))){
                this.Profilename = ar.get(i).getFirstname();
                return true;
            }
        }
        return false;
    }

    public boolean DisplayHomepage(){
        return true;

    }
    public boolean DisplayRegistration(){
        return true;
    }

    public boolean verifyRegistration(String[] RegisterInfo, ArrayList<UserEntityModel> ar)  {
        for(int i = 0; i < ar.size(); i++){
            if (RegisterInfo[2].equals(ar.get(i).getUsername().trim())){
                System.out.println("test");
                return false;
            }
        }
        return true;
    }
}


