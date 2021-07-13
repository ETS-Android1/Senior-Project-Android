package com.example.seniorproject.Views.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Activity.HomePageActivity;
import com.example.seniorproject.Views.Activity.LoginActivity;
import com.example.seniorproject.Views.Activity.SignUpActivity;
import com.google.android.material.button.MaterialButton;

public class StartingFragment extends Fragment {

    /** Private Member Variables **/
    private ImageView homePage;
    private MaterialButton signUpButton;
    private MaterialButton logInButton;
    private static String STARTING_FRAGMENT_TAG = "Starting Fragment";


    //Base Constructor
    public StartingFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_starting, container, false);
        homePage = (ImageView) view.findViewById(R.id.homepage_imageview);
        signUpButton = (MaterialButton) view.findViewById(R.id.signup_button);
        logInButton = (MaterialButton) view.findViewById(R.id.login_button);

        logInButton.setOnClickListener(e -> {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment(), LoginActivity.LOGIN_FRAGMENT_ACTIVITY)
                    .addToBackStack(null)
                    .commit();
        });

        signUpButton.setOnClickListener(e -> {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SignUpFragment(), SignUpActivity.SIGN_UP_FRAGMENT_ACTIVITY)
                    .addToBackStack(null)
                    .commit();
//            Intent intent = new Intent(getContext(), HomePageActivity.class);
//            intent.putExtra(STARTING_FRAGMENT_TAG, STARTING_FRAGMENT_TAG );
//            startActivity(intent);
        });

        return view;
    }

}
