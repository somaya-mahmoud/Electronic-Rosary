package com.example.electronicrosary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicrosary.UserSessions.UserData;

import java.io.IOException;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class EditProfileActivity extends AppCompatActivity {
    ImageView imageView;
    EditText name, email;
    Button save, select;
    UserData userData;
    private static final int GALLARY = 1;
    private static final int CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        imageView = findViewById(R.id.avatar);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save);
        select = findViewById(R.id.select);
        userData = new UserData(this);
        getSavedData();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData()) {
                    userData.saveData(name.getText().toString(), email.getText().toString(), true);
                }

            }
        });


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSelectionDialog();

            }
        });


    }


    private void showSelectionDialog() {
        AlertDialog.Builder selectionDialog = new AlertDialog.Builder(this);
        selectionDialog.setTitle("Select Action");
        String[] selectionDialogItems = {
                "Select photo from gallary",
                "Capture photo from camera"
        };
        selectionDialog.setItems(selectionDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
       //                 choosePhotoFromGallary();
                        break;
                    case 1:
     //                   takePhotoFromCamera();
                        break;
                }
            }

        });
        selectionDialog.show();
    }


        public boolean validateData () {
            if (name.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                return false;
            } else if (email.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;


        }

        void getSavedData () {
            name.setText(userData.getUserData().get(UserData.KEY_NAME));
            email.setText(userData.getUserData().get(UserData.KEY_EMAIL));

        }


    }

