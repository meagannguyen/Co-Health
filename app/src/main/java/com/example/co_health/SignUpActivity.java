package com.example.co_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    EditText emailIn, userIn, pwdIn, pwdIn2;
    Button createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        createAccountButton = findViewById(R.id.createAccountButton);
        emailIn = findViewById(R.id.emailAddress);
        userIn = findViewById(R.id.createUsername);
        pwdIn = findViewById(R.id.createPassword);
        pwdIn2 = findViewById(R.id.createPassword2);
    }

    public void gotoSignIn(View view) {
        Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
        startActivity(intent);
    }

    private boolean validateEmail(){
        String raw_email = emailIn.getEditableText().toString().trim();
        if(raw_email.isEmpty()){
            emailIn.setError("Please enter your email address");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(raw_email).matches()){
            emailIn.setError("Email format is invalid!");
            return false;
        }else{
            emailIn.setError(null);
            return true;
        }
    }

    private boolean validatePwds(){
        String p1 = pwdIn.getEditableText().toString().trim();
        String p2 = pwdIn2.getEditableText().toString().trim();
        if(p1.isEmpty()){
            pwdIn.setError("Please enter a password");
            return false;
        }else if(p2.isEmpty()){
            pwdIn2.setError("Please enter your password again");
            return false;
        }
        return pwdIn2.equals(pwdIn2);
    }
}