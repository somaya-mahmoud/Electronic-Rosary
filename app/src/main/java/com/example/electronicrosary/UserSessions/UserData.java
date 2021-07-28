package com.example.electronicrosary.UserSessions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.electronicrosary.Home.MainActivity;
import com.example.electronicrosary.Splash.SplashActivity;

import java.util.HashMap;

public class UserData {


    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myeditor;
    Context context;
    private static final  String FILE_NAME = "My_File";
    public static final  String KEY_NAME = "user_name";
    public static final  String KEY_EMAIL = "user_email";
    public static final  String KEY_STATUS = "user_status";
    public static final  String KEY_COUNTER = "user_counter";



    public UserData(Context context) {
        this.context = context;
        mysharedpreferences = context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE);
        myeditor  = mysharedpreferences.edit();


    }


    public void saveData(String name ,String email ,boolean status){
        myeditor.putString(KEY_NAME,name);
        myeditor.putString(KEY_EMAIL,email);
        myeditor.putBoolean(KEY_STATUS,status);
        myeditor.apply();
    }
    public  HashMap<String,String> getUserData(){
        HashMap<String,String> user = new HashMap<>();
        user.put(KEY_NAME,mysharedpreferences.getString(KEY_NAME,null));
        user.put(KEY_EMAIL,mysharedpreferences.getString(KEY_EMAIL,null));

        return user;

    }
    public boolean isLogin(){
        return mysharedpreferences.getBoolean(KEY_STATUS,false);
    }


    public void saveCounter(String counter){
        myeditor.putString(KEY_COUNTER,counter);
        myeditor.apply();

    }
    public String getCounter(){
        return mysharedpreferences.getString(KEY_COUNTER,"0");
    }


    public void logOut(){

        myeditor.clear();
        myeditor.commit();
        Intent intent = new Intent(context, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
