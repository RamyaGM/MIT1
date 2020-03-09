package com.example.notify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Email extends AppCompatActivity {
EditText To,Sub,Msg;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        To=(EditText)findViewById(R.id.editmail);
        Sub=(EditText)findViewById(R.id.mailsub);
       Msg=(EditText)findViewById(R.id.mailmsg);
b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String to=To.getText().toString();
        String sub=Sub.getText().toString();
        String msg=Msg.getText().toString();

        Intent email=new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT,new String[]{sub});
        email.putExtra(Intent.EXTRA_TEXT,new String[]{msg});
        email.setType("Message/rfc822");
        startActivity(Intent.createChooser(email,"Choose an Email client"));


    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Intent intent=new Intent(Email.this,Call.class) ;
       startActivity(intent);
    }
});
    }
}
