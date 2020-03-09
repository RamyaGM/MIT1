package com.example.notify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {
RatingBar ratingDemo;
Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ratingDemo=(RatingBar)findViewById(R.id.ratingdemo);
        bb=(Button)findViewById(R.id.ratingsubmit);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rvalue=ratingDemo.getRating();
                Toast.makeText(getApplicationContext(),
                        "Rating:-"+rvalue,Toast.LENGTH_LONG).show();
            }
        });
    }
}
