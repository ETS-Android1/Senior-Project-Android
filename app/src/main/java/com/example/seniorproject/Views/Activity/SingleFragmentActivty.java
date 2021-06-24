package com.example.seniorproject.Views.Activity;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.seniorproject.R;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class SingleFragmentActivty extends FragmentActivity {


    private MaterialToolbar materialToolbar;
    private DrawerLayout drawerLayout;
    protected abstract Fragment createFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlefragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment startingFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        /** Check if Fragment is empty **/
        if(startingFragment == null){
            startingFragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,startingFragment).commit();
        }

    }

}
