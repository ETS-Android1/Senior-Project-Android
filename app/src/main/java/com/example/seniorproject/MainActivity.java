package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seniorproject.Authentication.Authentication;
import com.example.seniorproject.User.User;

public class MainActivity extends AppCompatActivity {


    private Button logInButton;
    private Button signUpButton;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Authentication authentication;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInButton = (Button) findViewById(R.id.logIn_Button);
        userNameEditText = (EditText) findViewById(R.id.userName_TextBox);
        passwordEditText = (EditText) findViewById(R.id.userPassword_Textfield);

        logInButton.setOnClickListener(e -> {
            System.out.println("Hello");
        });
    }
}