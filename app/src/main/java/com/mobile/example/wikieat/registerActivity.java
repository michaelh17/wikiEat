package com.mobile.example.wikieat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {
    EditText usernameBox, emailBox, passwordBox, confirmBox;
    Button signupButton;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameBox = findViewById(R.id.usernameBox);
        emailBox = findViewById(R.id.emailBox);
        passwordBox = findViewById(R.id.passwordBox);
        confirmBox = findViewById(R.id.confirmBox);
        signupButton = findViewById(R.id.signupButton);
        TextView backLogin = findViewById(R.id.backLogin);
        mAuth = FirebaseAuth.getInstance();


        backLogin.setOnClickListener(view -> {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
            finish();
        });

        signupButton.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser(){
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
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplication(),"Register Succesful! Go Back to Login Page!",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplication(),"Register failed! : " +task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}