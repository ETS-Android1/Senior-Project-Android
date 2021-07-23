package com.example.seniorproject.Views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;

import Model.User;
import Presenters.SignUpActivityPresenter;

public class SignUpFragment extends Fragment implements SignUpActivityPresenter.View {

    private EditText userNameEditText;
    private EditText userFirstNameEditText;
    private EditText userLastNameEditText;
    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private EditText userConfirmPasswordEditText;
    private Button signUpButton;
    private SignUpActivityPresenter signUpActivityPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.signUpActivityPresenter = new SignUpActivityPresenter(this, getActivity().getBaseContext());

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        /** Construct Widgets **/
        userNameEditText = (EditText) view.findViewById(R.id.editTextUsername);
        userFirstNameEditText = (EditText) view.findViewById(R.id.editTextFirstName);
        userLastNameEditText = (EditText) view.findViewById(R.id.editTextLastName);
        userEmailEditText = (EditText) view.findViewById(R.id.editTextEmail);
        userPasswordEditText = (EditText) view.findViewById(R.id.editTextPassword);
        userConfirmPasswordEditText = (EditText) view.findViewById(R.id.editTextConfirmPassword);
        signUpButton = (Button) view.findViewById(R.id.signup_button);

        signUpButton.setOnClickListener(e -> {
            if (signUpActivityPresenter.isFieldsEmpty(userNameEditText.getText().toString(),
                    userNameEditText.getText().toString(), userLastNameEditText.getText().toString(),
                    userEmailEditText.getText().toString(), userPasswordEditText.getText().toString(),
                    userConfirmPasswordEditText.getText().toString())) {
                Toast.makeText(getContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
            }
            // check if userName already exists in the database
            else if(signUpActivityPresenter.checkUserName(userNameEditText.getText().toString())){
                Toast.makeText(getContext(), "Username already exists.", Toast.LENGTH_SHORT).show();
            }
            // check if email entry already exists in the database
            else if(signUpActivityPresenter.checkEmail(userEmailEditText.getText().toString())){
                Toast.makeText(getContext(), "This email is already associated with an account.", Toast.LENGTH_SHORT).show();
            }
            else if(!signUpActivityPresenter.checkPassword(userPasswordEditText.getText().toString(), userConfirmPasswordEditText.getText().toString())){
                Toast.makeText(getContext(), "Password is not the same.", Toast.LENGTH_SHORT).show();
            }
            else {
                signUpActivityPresenter.insertUser(new User(userNameEditText.getText().toString(),
                        userNameEditText.getText().toString(), userLastNameEditText.getText().toString(),
                        userEmailEditText.getText().toString(), userPasswordEditText.getText().toString(),
                        userConfirmPasswordEditText.getText().toString()));
                Toast.makeText(getContext(), "User Inserted", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}
