package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.google.android.material.appbar.MaterialToolbar;


public class HomePageFragment extends Fragment {


    private DrawerLayout drawerLayout;
    private MaterialToolbar materialToolbar;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflate the Sign Up Fragment **/
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        drawerLayout= (DrawerLayout) view.findViewById(R.id.drawerLayout);
        materialToolbar = (MaterialToolbar) view.findViewById(R.id.topAppBar);

        materialToolbar.setNavigationOnClickListener(e -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });


        return view;
    }
}
