package com.example.seniorproject.Views.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Activity.HomePageActivity;
import com.example.seniorproject.Views.Activity.LoginActivity;
import com.example.seniorproject.Views.Activity.StartingActivity;

import androidx.fragment.app.Fragment;

import Model.Login;

public class LoginFragment extends Fragment {
    private ImageView mBackgroundImage;
    private Login mLogin;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mLoginButton;
    private Button mRegisterButton;
    private String exampleUsername = "Admin";
    private String examplePassword = "password";
    private boolean isValid = false;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mLogin = new Login();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mBackgroundImage = (ImageView)v.findViewById(R.id.loginBackground);

        // Username text field
        mUsernameField = (EditText)v.findViewById(R.id.editTextUsername);
        mUsernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // can leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setUsername(s.toString());   // setUsernameTextField
            }

            @Override
            public void afterTextChanged(Editable s) {
                // can leave blank
            }
        });

        // Password text field
        mPasswordField = (EditText)v.findViewById(R.id.editTextPassword);
        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // can leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setPassword(s.toString());   // setUsernameTextField
            }

            @Override
            public void afterTextChanged(Editable s) {
                // can leave blank
            }
        });

        mRegisterButton = (Button)v.findViewById(R.id.signup_button3);
        mLoginButton = (Button)v.findViewById(R.id.login_button2);
        mLoginButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = mLogin.getUsername();
                String inputPassword = mLogin.getPassword();
                System.out.println(inputName);
                System.out.println(inputPassword);

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(getContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                } else{
                    isValid = validate(inputName, inputPassword);
                    System.out.println(isValid);
                    if(isValid == false){
                        Toast.makeText(getContext(), "Incorrect credentials.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Login successful!", Toast.LENGTH_SHORT).show();

                        // Add code to go to the new activity. Homepage (logged in)
                        Intent intent = new Intent(getContext(), StartingActivity.class); //intent(source,activity)
                        // now that you have an intent, start the activity
                        startActivity(intent);


                    }
                }

            }
        }));


        return v;
    }

    // returns true if the there is a matching username and password
    private boolean validate(String username, String password){
        if (username.equals(exampleUsername) && password.equals(examplePassword)){
            return true;
        }
        return false;
    }

}
