package com.mobile.example.wikieat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText emailBox , passwordBox;
    Button loginButton , exitButton, resetButton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailBox = findViewById(R.id.emailBox);
        passwordBox = findViewById(R.id.passwordBox);
        TextView signupText = findViewById(R.id.signupText);
        loginButton = findViewById(R.id.loginButton);
        exitButton = findViewById(R.id.exitButton);
        resetButton = findViewById(R.id.resetButton);
        mAuth = FirebaseAuth.getInstance();

        signupText.setOnClickListener(view -> {
            Intent signupPage = new Intent(this, registerActivity.class);
            startActivity(signupPage);
            finish();
        });

        exitButton.setOnClickListener(view -> {
            finish();
        });

        resetButton.setOnClickListener(view -> {
            emailBox.setText("");
            passwordBox.setText("");
            emailBox.requestFocus();
        });

        loginButton.setOnClickListener(view->{
            loginUser();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            Toast.makeText(getApplication(), "Welcome to wikiEat!", Toast.LENGTH_LONG).show();
        }
    }

    private void loginUser(){
        String email = emailBox.getText().toString();
        String password = passwordBox.getText().toString();

        if (TextUtils.isEmpty(email)){
            emailBox.setError("Please enter valid email!");
            emailBox.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            passwordBox.setError("Please enter valid password!");
            passwordBox.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent login = new Intent(MainActivity.this, homepageActivity.class);
                        login.putExtra("user",email);
                        startActivity(login);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplication(),"Log in failed! : " +task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}