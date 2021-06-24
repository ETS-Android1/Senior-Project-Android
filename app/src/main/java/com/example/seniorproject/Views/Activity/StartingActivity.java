package com.example.seniorproject.Views.Activity;

import androidx.fragment.app.Fragment;

import com.example.seniorproject.Views.Fragment.StartingFragment;

public class StartingActivity extends SingleFragmentActivty {

    @Override
    protected Fragment createFragment() {
        return new StartingFragment();
    }
}
