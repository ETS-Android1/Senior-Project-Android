package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.seniorproject.R;

import androidx.fragment.app.Fragment;

import Model.User;
import Presenters.ProfileActivityPresenter;

public class ProfileFragment extends Fragment implements ProfileActivityPresenter.View {
    private EditText userNameEditText;
    private EditText userFirstNameEditText;
    private EditText userLastNameEditText;
    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private EditText userConfirmPasswordEditText;
    private Button signUpButton;
    private ProfileActivityPresenter profileActivityPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.profileActivityPresenter = new ProfileActivityPresenter(this, getActivity().getBaseContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        /** Construct Widgets **/
        userNameEditText = (EditText) view.findViewById(R.id.editTextUsername);
        userFirstNameEditText = (EditText) view.findViewById(R.id.editTextFirstName);
        userLastNameEditText = (EditText) view.findViewById(R.id.editTextLastName);
        userEmailEditText = (EditText) view.findViewById(R.id.editTextEmail);
        userPasswordEditText = (EditText) view.findViewById(R.id.editTextPassword);
        userConfirmPasswordEditText = (EditText) view.findViewById(R.id.editTextConfirmPassword);
        signUpButton = (Button) view.findViewById(R.id.signup_button);

        signUpButton.setOnClickListener(e -> {
        });


        return view;
    }
}

