package com.example.electronicrosary.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.example.electronicrosary.EditProfileActivity;
import com.example.electronicrosary.Maps.MapsActivity;
import com.example.electronicrosary.R;
import com.example.electronicrosary.UserSessions.UserData;

public class MainActivity extends AppCompatActivity {

    TextView textView;
   LottieAnimationView lottieAnimationView;
    SwipeButton swipeButton;
    int counter;
    UserData userData;
    ImageView imageView;
    PopupWindow popupWindow = null;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animation_view);
        textView = findViewById(R.id.count_tv);
        swipeButton = findViewById(R.id.swipe_btn);
        imageView = findViewById(R.id.open_pop);
        userData = new UserData(this);
        counter = Integer.parseInt(userData.getCounter());
        Log.e("Counter Value", counter + "");
        textView.setText(counter + "");
        userData.saveCounter(String.valueOf(counter));
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationView.playAnimation();
                counter++;
                textView.setText(String.valueOf(counter));

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intiatePopupWindow();

            }
        });
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                counter = 0;
                textView.setText(counter + "");
                userData.saveCounter(counter + "");

            }
        });



    }
    private PopupWindow intiatePopupWindow(){

        try {
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = layoutInflater.inflate(R.layout.items, null);
            final TextView EditProfileTv = layout.findViewById(R.id.edit_profile);
            EditProfileTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Intent intent = new Intent(MainActivity.this,EditProfileActivity.class);
                   startActivity(intent);

                }
            });


            final TextView OurLocationsTv = layout.findViewById(R.id.location_tv);
            OurLocationsTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);


                }
            });
            final TextView AboutUsTv = layout.findViewById(R.id.about_tv);
            AboutUsTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            final TextView LogOutTv = layout.findViewById(R.id.logout_tv);
            LogOutTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userData.logOut();

                }
            });
            layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            float scale = getResources().getDisplayMetrics().density;
            popupWindow = new PopupWindow(layout, (int) (180 * scale), (int) (220 * scale), true);
            Drawable background = getResources().getDrawable(R.drawable.popup_menu);
            popupWindow.setBackgroundDrawable(background);
            popupWindow.showAsDropDown(imageView, 5, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return popupWindow ;
    }
            }











