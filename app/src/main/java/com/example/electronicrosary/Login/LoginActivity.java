
package com.example.electronicrosary.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electronicrosary.Home.MainActivity;
import com.example.electronicrosary.R;
import com.example.electronicrosary.UserSessions.UserData;


public class LoginActivity extends AppCompatActivity {
    EditText Name,Email;
    Button login;
    UserData userdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name = findViewById(R.id.edit_name);
        Email = findViewById(R.id.edit_email);
        login = findViewById(R.id.login);

        userdata = new UserData(LoginActivity.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateData()){
                    userdata.saveData(Name.getText().toString(),Email.getText().toString(),true);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                }


            }
        });

    }
    public boolean validateData(){
        if(Name.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Email.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;


        }
    }
