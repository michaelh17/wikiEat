package com.mobile.example.wikieat;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;

public class aboutActivity extends AppCompatActivity {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(view->{
          this.finish();
        });
    }
}