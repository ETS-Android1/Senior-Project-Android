package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seniorproject.Authentication.Authentication;

public class MainActivity extends AppCompatActivity {


    private ImageView homePage;
    private Button signUpButton;
    private Button logInButton;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homePage = (ImageView) findViewById(R.id.homepage_imageview);

        signUpButton = (Button) findViewById(R.id.signup_button);
        logInButton = (Button) findViewById(R.id.login_button);
        signUpButton.setOnClickListener(e -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            intent.putExtra(EXTRA_MESSAGE, "New Acitivty");
            startActivity(intent);
        });
    }
}