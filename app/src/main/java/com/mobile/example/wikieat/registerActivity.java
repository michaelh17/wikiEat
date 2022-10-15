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

public class registerActivity extends AppCompatActivity {
    EditText emailBox, passwordBox, confirmBox;
    Button signupButton, resetButton;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailBox = findViewById(R.id.emailBox);
        passwordBox = findViewById(R.id.passwordBox);
        confirmBox = findViewById(R.id.confirmBox);
        signupButton = findViewById(R.id.signupButton);
        resetButton = findViewById(R.id.resetButton);
        TextView backLogin = findViewById(R.id.backLogin);
        mAuth = FirebaseAuth.getInstance();

        resetButton.setOnClickListener(view -> {
            emailBox.setText("");
            passwordBox.setText("");
            confirmBox.setText("");
            emailBox.requestFocus();
        });

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
        String confirmPass = confirmBox.getText().toString();

        if (TextUtils.isEmpty(email)){
            emailBox.setError("Please enter valid email!");
            emailBox.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            passwordBox.setError("Please enter valid password!");
            passwordBox.requestFocus();
        }
        else{

            if(password.equals(confirmPass)){
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplication(),"Register Successful! Go Back to Login Page!",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplication(),"Register failed! : " +task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });

            }

            else{
                passwordBox.setError("");
                confirmBox.setError("Password not match!");
                confirmBox.requestFocus();
            }
        }
    }
}