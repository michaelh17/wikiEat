package com.mobile.example.wikieat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import com.google.firebase.auth.FirebaseAuth;
public class homepageActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();

        TextView userLogin = findViewById(R.id.userLogin);
        TextView logout = findViewById(R.id.logoutText);
        Bundle getter = intent.getExtras();


        if (getter!=null){
            userLogin.setText(getter.getString("user"));
        }

        logout.setOnClickListener(view->{
            mAuth.signOut();
            Intent logoutIntent = new Intent(this, MainActivity.class);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logoutIntent);
        });


    }
}