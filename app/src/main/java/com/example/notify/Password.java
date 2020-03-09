package com.example.notify;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Password extends AppCompatActivity {
    Button btn;
    private TextView mHeading;
    private ImageView mFinger;
    private TextView mPara;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        btn=(Button)findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Password.this,Login_Home.class);
                startActivity(intent);
            }
        });
        mHeading=(TextView)findViewById(R.id.textView);
        mFinger=(ImageView)findViewById(R.id.imageView3);
        mPara=(TextView)findViewById(R.id.textView3);
        //1:Android version should be greater or equal to marshallow
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            fingerprintManager=(FingerprintManager)getSystemService(FINGERPRINT_SERVICE);
            keyguardManager=(KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            //2:Device has FingerPrint Scanner
            if(!fingerprintManager.isHardwareDetected())
            {
                mPara.setText("FingerPrint Scanner not detected in Device");
            }
            else
                //3:have permission to use fingerprint in he app
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)!= PackageManager.PERMISSION_GRANTED)
                {
                    mPara.setText("Permission not grated to use Fingerprint");
                }
                //4:Lock screen is secured with atleast 1 type of lock
                else if(!keyguardManager.isKeyguardSecure())
                {

                    mPara.setText("Add lock to your phone in Settings");

                }
                //5:atleast 1 fingerprint is registered
                else if(!fingerprintManager.hasEnrolledFingerprints())
                {
                    mPara.setText("you should have atleast one fingerprint feature");
                }

                else
                {
                    mPara.setText("Place put your finger on scanner to access this app");
                    FingerPrintHandler fingerPHandler=new FingerPrintHandler(this);

                    fingerPHandler.startAuth(fingerprintManager,null);





                }
        }

    }
}
