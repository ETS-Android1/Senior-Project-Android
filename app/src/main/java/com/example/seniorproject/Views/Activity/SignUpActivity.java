package com.example.seniorproject.Views.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Fragment.HomePageFragment;
import com.example.seniorproject.Views.Fragment.LoginFragment;

public class SignUpActivity extends SingleFragmentActivity {

    public static String SIGN_UP_FRAGMENT_ACTIVITY = "Sign Up Fragment Activity";

    @Override
    protected Fragment createFragment() {
        return new HomePageFragment();
    }
}
