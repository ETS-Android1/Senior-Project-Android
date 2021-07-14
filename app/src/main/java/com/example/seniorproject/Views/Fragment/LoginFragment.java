package com.example.seniorproject.Views.Fragment;

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
        mLoginButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginActvityPresenter.isUserNameOrPassWordEmpty(mUsernameField.getText().toString(), mPasswordField.getText().toString())) {
                    Toast.makeText(getContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                } else {
//                    isValid = loginActvityPresenter.validate(userInputUserName, userInputPassword);
//                    System.out.println(isValid);
                    if (!(loginActvityPresenter.validateUser(mUsernameField.getText().toString(), mPasswordField.getText().toString()))) {
                        Toast.makeText(getContext(), "Incorrect credentials.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Login successful!", Toast.LENGTH_SHORT).show();


                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new HomePageFragment(), "TAG")
                                .addToBackStack(null)
                                .commit();

                        /**
                         // Add code to go to the new activity. Homepage (logged in)
                         Intent intent = new Intent(getContext(), StartingActivity.class); //intent(source,activity)
                         // now that you have an intent, start the activity
                         startActivity(intent);
                         **/

                    }
                }

            }
        }));

        return v;
    }

}
