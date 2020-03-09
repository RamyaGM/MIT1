package com.example.notify;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Call extends AppCompatActivity {
    EditText et;
    String telNum;
    Button call;
    ListView lv;
    ArrayList<String> sms;
    Cursor c;
    private static final int READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        et = (EditText) findViewById(R.id.et);
        call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                telNum = et.getText().toString();
                if (telNum.trim().isEmpty()) {
                    intent.setData(Uri.parse("tel:567788"));


                } else {
                    intent.setData(Uri.parse("tel:" + telNum));

                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions();
                } else {
                    startActivity(intent);
                }
            }

            private void requestPermissions() {
                ActivityCompat.requestPermissions(Call.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        });

    }

}