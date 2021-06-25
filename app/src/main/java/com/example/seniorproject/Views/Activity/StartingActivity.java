package com.example.seniorproject.Views.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.seniorproject.Views.Fragment.StartingFragment;

public class StartingActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return new StartingFragment();
    }
}
