package com.example.seniorproject.Views.Activity;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.seniorproject.R;
import com.example.seniorproject.Views.Fragment.LoginFragment;
import com.google.android.material.appbar.MaterialToolbar; //prob not used

public class LoginActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.login_fragment_container);

        if (fragment == null) { // if the fragment wasn't already created, then make new one
            fragment = new LoginFragment();
            // fragment transactions are used to add, remove, detach, replace fragments in fragment list
            // "heart of how you use fragments to compose and recompose screens at runtime"
            fm.beginTransaction().add(R.id.login_fragment_container, fragment).commit(); //Create a new fragment transaction, include one add operation in it, and then commit it
        }
    }
}
