package com.example.notify;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class share extends AppCompatActivity {
    Button b1;
    String telNum;
    EditText edcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        edcl = (EditText) findViewById(R.id.edcl);
        b1 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("Text/Plain");
               shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert sub here");
                String app_url = "https://play.google.com/store/apps/details?id=com.example.administrator";
              shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser(shareIntent, "share via"));


            }
        });

    }

    private void requestPermission ()
    {
        ActivityCompat.requestPermissions(share.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

    }



