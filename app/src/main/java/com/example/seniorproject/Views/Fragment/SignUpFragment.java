package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.google.android.material.appbar.MaterialToolbar;

public class SignUpFragment extends Fragment {


    MaterialToolbar materialToolbar;
    DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflate the Sign Up Fragment **/
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        materialToolbar = (MaterialToolbar) view.findViewById(R.id.topAppBar);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.signup_drawer_layout);

        materialToolbar.setNavigationOnClickListener( e -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });

        return view;
    }
}
