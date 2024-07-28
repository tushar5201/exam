package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    ImageView imgLogo;
    TextView tvAppname, tvDot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation zoom;
        final Animation[] fade = new Animation[1];
//        final Animation[] fade = new Animation[1];

        imgLogo = findViewById(R.id.imgLogo);
        tvAppname = findViewById(R.id.tvAppname);

        zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_anim);
        imgLogo.startAnimation(zoom);

        fade[0] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_anim);
        tvAppname.startAnimation(fade[0]);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                fade[0] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_anim);
//                tvDot.startAnimation(fade[0]);
                tvAppname.setText("...");
                fade[0] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_anim);
                tvAppname.startAnimation(fade[0]);
            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, Login.class);
                startActivity(mainIntent);
            }
        }, 4500);
    }
}