package com.chaurasiya.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCall;
    Button btnMsg;
    Button btnEmail;
    Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = findViewById(R.id.btnCall);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
//                iDial.setAction(Intent.ACTION_DIAL);// both are correct ways to pass dial action
//                iDial.setData(Uri.parse("tel:"+Uri.encode("+919129611321")));
                iDial.setData(Uri.parse("tel: +919129611321"));
//                startActivity(iDial);
                startActivity(Intent.createChooser(iDial, "Call Via"));



//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:"+9129611321));
//                startActivity(callIntent);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
//                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+919129611321")));
                iMsg.setData(Uri.parse("smsto: +919129611321"));
                iMsg.putExtra("sms_body", "Please solve this issue asap");
                startActivity(iMsg);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822"); // to determine msg from email only;
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String [] {"himanshuchaurasiya24@gmail.com", "hc24199@gmail.com", "himanshuch24@outlook.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please Resolve this issue asap");
                startActivity(Intent.createChooser(iEmail,"Email via:"));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain"); // to determine normal share;
                iShare.putExtra(Intent.EXTRA_TEXT, "Download this amazing app, https://play.google.com/store/apps/details?id=offroad.racing.game");
                startActivity(Intent.createChooser(iShare, "Share Via"));
            }
        });
    }
}


















