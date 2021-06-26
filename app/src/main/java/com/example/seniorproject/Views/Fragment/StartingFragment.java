package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Activity.LoginActivity;
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
                    .replace(R.id.fragment_container, new LoginFragment(), STARTING_FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit();
        });

        signUpButton.setOnClickListener(e -> {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HomePageFragment(), STARTING_FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

}
