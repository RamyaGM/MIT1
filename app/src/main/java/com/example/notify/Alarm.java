package com.example.notify;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class Alarm extends AppCompatActivity  implements View.OnClickListener {
    private int notification = 1;
    EditText editText;
    TimePicker timePicker;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        b1=(Button)findViewById(R.id.btn);
        b2=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent=new Intent(getApplicationContext(),Speech.class);
                //startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getApplicationContext(),QRcode.class);
               // startActivity(intent);

            }
        });
        /* CircleMenu circleMenu =findViewById(R.id.cm);
        final String[] menus={
                "Restorent",
                "Airoplane",
                "mall"
        };
       circleMenu.setMainMenu(Color.parseColor("#cdcdcd"),R.drawable.ic_add,R.drawable.ic_clear)
                .addSubMenu(Color.parseColor("#cdcdcd"),R.drawable.ic_text_format)
                .addSubMenu(Color.parseColor("#cdcdcd"),R.drawable.ic_scanner_black_24dp)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

        @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(Alarm.this, "you click" +menus[index], Toast.LENGTH_SHORT).show();
                    }
                });

*/
        //setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        EditText editText=findViewById(R.id.ed);
        TimePicker timePicker=findViewById(R.id.tp);
        Intent intent=new Intent(Alarm.this,AAlarmReceiver.class);
        intent.putExtra("notification",notification);
        intent.putExtra("todo",editText.getText().toString());
        PendingIntent alarmIntent=PendingIntent.getBroadcast(Alarm.this,0,intent,PendingIntent
                .FLAG_CANCEL_CURRENT);
        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        switch (view.getId())
        {
            case R.id.btn:
                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                Calendar startTime= Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime=startTime.getTimeInMillis();

                //set alarm
                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn1:

                alarm.cancel(alarmIntent);

                Toast.makeText(this,"Canceled.",Toast.LENGTH_SHORT).show();
                break;



        }
    }
}
