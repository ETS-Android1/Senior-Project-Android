package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.seniorproject.R;

import androidx.fragment.app.Fragment;

import Model.Login;
import Presenters.LoginActvityPresenter;

public class LoginFragment extends Fragment implements LoginActvityPresenter.View {
    private ImageView mBackgroundImage;
    //    private Login mLogin;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mLoginButton;
    private Button mRegisterButton;
    private String exampleUsername = "Admin";
    private String examplePassword = "password";
    private boolean isValid = false;
    private LoginActvityPresenter loginActvityPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        loginActvityPresenter = new LoginActvityPresenter(this, getActivity().getBaseContext());

        mBackgroundImage = (ImageView) v.findViewById(R.id.loginBackground);

        // Username text field
        mUsernameField = (EditText) v.findViewById(R.id.editTextUsername);
        mUsernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // can leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginActvityPresenter.userSetUsername(s.toString());   // setUsernameTextField
            }

            @Override
            public void afterTextChanged(Editable s) {
                // can leave blank
            }
        });

        // Password text field
        mPasswordField = (EditText) v.findViewById(R.id.editTextPassword);
        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // can leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginActvityPresenter.userSetPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // can leave blank
            }
        });

        mRegisterButton = (Button) v.findViewById(R.id.signup_button3);

        mLoginButton = (Button) v.findViewById(R.id.login_button2);
        mLoginButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputUserName = loginActvityPresenter.userGetUsername();
                String userInputPassword = loginActvityPresenter.userGetPassword();
//                System.out.println(userInputUserName);
//                System.out.println(userInputPassword);

                if (loginActvityPresenter.isUserNameOrPassWordEmpty(userInputUserName, userInputPassword)) {
                    Toast.makeText(getContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                } else {
//                    isValid = loginActvityPresenter.validate(userInputUserName, userInputPassword);
//                    System.out.println(isValid);
                    if (!(loginActvityPresenter.validateUser(userInputUserName, userInputPassword))) {
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
