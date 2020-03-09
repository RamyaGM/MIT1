package com.example.notify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Grid extends AppCompatActivity implements View.OnClickListener {
private CardView a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        a=(CardView)findViewById(R.id.bankcardId);
        b=(CardView)findViewById(R.id.l1);
        c=(CardView)findViewById(R.id.m1);
        d=(CardView)findViewById(R.id.n1);
        e=(CardView)findViewById(R.id.o1);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.bankcardId : i= new Intent(this,Alarm.class);startActivity(i);break;
            case R.id.l1 : i= new Intent(this,Location.class);startActivity(i);break;
            case R.id.m1 : i= new Intent(this,Email.class);startActivity(i);break;
            case R.id.n1 : i= new Intent(this,Rating.class);startActivity(i);break;
            case R.id.o1 : i= new Intent(this,share.class);startActivity(i);break;
            default:break;
        }
    }
}
