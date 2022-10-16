package com.mobile.example.wikieat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;


import com.google.firebase.auth.FirebaseAuth;
public class homepageActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button infoButton, foodButton, aboutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        infoButton = findViewById(R.id.infoButton);
        foodButton = findViewById(R.id.foodButton);
        aboutButton = findViewById(R.id.aboutButton);

        TextView userLogin = findViewById(R.id.userLogin);
        TextView logout = findViewById(R.id.logoutText);
        Bundle getter = intent.getExtras();


        if (getter!=null){
            userLogin.setText(getter.getString("user"));
        }

        infoButton.setOnClickListener(view->{
            Intent contact = new Intent(this,contactActivity.class);
            startActivity(contact);
        });
        logout.setOnClickListener(view->{
            mAuth.signOut();
            Intent logoutIntent = new Intent(this, MainActivity.class);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logoutIntent);
        });

        foodButton.setOnClickListener(view->{
            Intent food = new Intent(this,foodCatalog.class);
            startActivity(food);
        });

        aboutButton.setOnClickListener(view->{
           Intent about = new Intent(this,aboutActivity.class);
           startActivity(about);
        });


    }
}