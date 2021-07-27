package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.seniorproject.R;

import androidx.fragment.app.Fragment;

import Presenters.LoginActivityPresenter;

public class LoginFragment extends Fragment implements LoginActivityPresenter.View {
    private ImageView mBackgroundImage;
    //    private Login mLogin;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mLoginButton;
    //    private Button mRegisterButton;
//    private String exampleUsername = "Admin";
//    private String examplePassword = "password";
//    private boolean isValid = false;
    private LoginActivityPresenter loginActvityPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActvityPresenter = new LoginActivityPresenter(this, getActivity().getBaseContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);


        mBackgroundImage = (ImageView) v.findViewById(R.id.loginBackground);

        // Username text field
        mUsernameField = (EditText) v.findViewById(R.id.editTextUsername);

        // Password text field
        mPasswordField = (EditText) v.findViewById(R.id.editTextPassword);

        mLoginButton = (Button) v.findViewById(R.id.login_button2);
        mLoginButton.setOnClickListener((e -> {
                /**  Validate **/
                if(loginActvityPresenter.checkLogin(mUsernameField.getText().toString().trim(), mPasswordField.getText().toString().trim())){
                    Toast.makeText(getActivity().getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new HomePageFragment(), HomePageFragment.HOMEPAGE_FRAGMENT_ACTIVITY)
                            .addToBackStack(null)
                            .commit();
                }

        }));

        return v;

    }
}
