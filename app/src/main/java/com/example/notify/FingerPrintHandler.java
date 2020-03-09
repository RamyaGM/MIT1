package com.example.notify;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

public class FingerPrintHandler extends FingerprintManager.AuthenticationCallback {

    private Context context;
    public FingerPrintHandler(Context context)
    {
        this.context=context;
    }
    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject)
    {
        CancellationSignal cancellationSignal=new CancellationSignal();

        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);

        this.update("There was an authrity."+ errString,false);

    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();

        this.update("Action failed",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        this.update("Help String "+helpString,false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        this.update("you can now access the app",true);



    }

    private void update(String s, boolean b) {
        TextView paraLabel=(TextView)((Activity)context).findViewById(R.id.textView3);
        ImageView imageview=(ImageView)((Activity)context).findViewById(R.id.imageView3);
        paraLabel.setText(s);
        if(b==false)
        {
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
        }
        else
        {
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
            imageview.setImageResource(R.drawable.download);
        }
    }
}




