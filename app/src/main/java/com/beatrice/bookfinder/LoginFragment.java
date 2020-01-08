package com.beatrice.bookfinder;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        final TextInputEditText usernameEditTxt = rootView.findViewById(R.id.username_edittxt);
        Button btnContinue = rootView.findViewById(R.id.login_btn);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameEditTxt.getText().toString();
                if (!TextUtils.isEmpty(name)) {
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_mainFragment);
                } else
                    usernameEditTxt.setError("Field Cannot be empty");
                usernameEditTxt.requestFocus();
            }
        });

        return rootView;
    }

}
