package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.seniorproject.R;
import androidx.fragment.app.Fragment;

import Model.Login;

public class LoginFragment extends Fragment {
    private ImageView mBackgroundImage;
    private Login mLogin;
    private EditText mUsernameField;
    private EditText mPasswordField;

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
                mLogin.setUsername(s.toString());   // setUsernameTextField
            }

            @Override
            public void afterTextChanged(Editable s) {
                // can leave blank
            }
        });

        return v;
    }

}
