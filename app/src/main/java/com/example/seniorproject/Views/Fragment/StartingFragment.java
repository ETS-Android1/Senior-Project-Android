package com.example.seniorproject.Views.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Activity.HomePageActivity;
import com.example.seniorproject.Views.Activity.LoginActivity;
import com.example.seniorproject.Views.Activity.SignUpActivity;
import com.google.android.material.button.MaterialButton;

import Presenters.LoginActivityPresenter;
import Presenters.SignUpActivityPresenter;

public class StartingFragment extends Fragment implements LoginActivityPresenter.View, SignUpActivityPresenter.View {

    /**
     * Private Member Variables
     **/
    private ImageView homePage;
    private EditText userNameEditText;
    private EditText userFirstNameEditText;
    private EditText userLastNameEditText;
    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private EditText userConfirmPasswordEditText;
    private MaterialButton signUpButton;
    private MaterialButton logInButton;
    private int loginButtonClickCounter = 0;
    public static String STARTING_FRAGMENT_TAG = "Starting Fragment";
    Animation aniSlide;

    /**
     * Login Presenter
     **/
    private LoginActivityPresenter loginActvityPresenter;
    private SignUpActivityPresenter signUpActivityPresenter;


    //Base Constructor
    public StartingFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.loginActvityPresenter = new LoginActivityPresenter(this, getActivity().getBaseContext());
        this.signUpActivityPresenter = new SignUpActivityPresenter(this, getActivity().getBaseContext());

    }

    @Override
    public void onStart() {
        super.onStart();
        aniSlide = AnimationUtils.loadAnimation(getActivity().getBaseContext(), R.anim.slide_up);
        aniSlide.setDuration(800);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_starting, container, false);
        homePage = (ImageView) view.findViewById(R.id.homepage_imageview);
        signUpButton = (MaterialButton) view.findViewById(R.id.signup_button);
        logInButton = (MaterialButton) view.findViewById(R.id.login_button);
        userNameEditText = (EditText) view.findViewById(R.id.editTextUsername);
        userFirstNameEditText = (EditText) view.findViewById(R.id.editTextFirstName);
        userLastNameEditText = (EditText) view.findViewById(R.id.editTextLastName);
        userEmailEditText = (EditText) view.findViewById(R.id.editTextEmail);
        userPasswordEditText = (EditText) view.findViewById(R.id.editTextPassword);
        userConfirmPasswordEditText = (EditText) view.findViewById(R.id.editTextConfirmPassword);

        logInButton.setOnClickListener(e -> {
            if(loginButtonClickCounter >= 1) {
                homePage.setVisibility(View.INVISIBLE);
                if (loginActvityPresenter.checkLogin(userEmailEditText.getText().toString().trim(), userPasswordEditText.getText().toString().trim())) {
                    Toast.makeText(getActivity().getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new HomePageFragment(), HomePageFragment.HOMEPAGE_FRAGMENT_ACTIVITY)
                            .addToBackStack(null)
                            .commit();
                }
            }
                ++loginButtonClickCounter;
                homePage.startAnimation(aniSlide);
                System.out.println("Animation Duration: " + aniSlide.getDuration());
                view.setBackgroundColor(Color.BLACK);
                homePage.setVisibility(View.INVISIBLE);
                userNameEditText.setVisibility(View.INVISIBLE);
                userFirstNameEditText.setVisibility(View.INVISIBLE);
                userLastNameEditText.setVisibility(View.INVISIBLE);
                userConfirmPasswordEditText.setVisibility(View.INVISIBLE);
                userEmailEditText.setHint("Username");
                homePage.setVisibility(View.INVISIBLE);


        });

        signUpButton.setOnClickListener(e -> {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SignUpFragment(), SignUpActivity.SIGN_UP_FRAGMENT_ACTIVITY)
                    .addToBackStack(null)
                    .commit();
        });


        return view;
    }

}
