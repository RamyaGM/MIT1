package com.example.notify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Handler handler;
    MediaPlayer mmp;
    Animation animinter;
    ImageView imaginter;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.btn1);
        imaginter=(ImageView)findViewById(R.id.imageView);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,Login_Home.class);
                startActivity(intent);
                finish();



            }
        },2000);

        //mmp= MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        //mmp.start();

    }
}

