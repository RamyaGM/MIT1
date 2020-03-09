package com.example.notify;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class setAlarm extends AppCompatActivity {
    DatePicker dap;
    TimePicker tap;
    Button Alarm ,b,b1;
    TextView info;
    Ringtone ringtone;
    final static int RQS_1 = 1;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);


        info=(TextView)findViewById(R.id.text1);
        b=(Button)findViewById(R.id.btn3);
        b1=(Button)findViewById(R.id.qr);
        dap=(DatePicker)findViewById(R.id.dp);
        tap=(TimePicker)findViewById(R.id.tp);

        Calendar now=Calendar.getInstance();
        dap.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);
        tap.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        tap.setCurrentMinute(now.get(Calendar.MINUTE));
        Alarm=(Button)findViewById(R.id.save);
        Alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar current=Calendar.getInstance();
                Calendar cal=Calendar.getInstance();
                cal.set(dap.getYear(),
                        dap.getMonth(),
                        dap.getDayOfMonth(),
                        tap.getCurrentHour(),
                        tap.getCurrentMinute(),00);
                if(cal.compareTo(current)<=0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Date/Time",Toast.LENGTH_LONG).show();
                }
                else
                {
                    setAlarm(cal);
                }
            }
        });


    }

    private void setAlarm(Calendar cal) {
        info.setText("\n \n "+"Alarm is set @"+cal.getTime()+"\n"+"\n");
        Intent intent=new Intent(getBaseContext(),MyBroadcastReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getBaseContext(),RQS_1,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
        Uri uri= RingtoneManager.getDefaultUri(R.raw.ringtone);
        String currentDateTimeString= DateFormat.getDateTimeInstance().format(new Date());
        if((cal.getTime()).equals(currentDateTimeString))
        {
            ringtone=RingtoneManager.getRingtone(getApplicationContext(),uri);
        }
    }
}
