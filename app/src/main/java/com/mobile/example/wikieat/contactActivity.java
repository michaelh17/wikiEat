package com.mobile.example.wikieat;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

public class contactActivity extends AppCompatActivity {
    Button callButton , emailButton , backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        callButton = findViewById(R.id.callButton);
        emailButton = findViewById(R.id.emailButton);
        backButton = findViewById(R.id.backButton);


        backButton.setOnClickListener(view->{
            this.finish();
        });


        callButton.setOnClickListener(view->{
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:082280675281"));
            startActivity(call);
        });

        emailButton.setOnClickListener(view->{
            String email = "kelompok1@student.ubm.ac.id";
            String subject = "Automatic Template";
            String message = "Hello, this is an automatic message template to contact wikiEat Admin!";
            String mail = "mailto:" + email +
                    "?&subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(message);
            Intent kirimemail = new Intent(Intent.ACTION_SENDTO);
            kirimemail.setData(Uri.parse(mail));
            startActivity(Intent.createChooser(kirimemail,"Contact Us"));

        });
    }
}