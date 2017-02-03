package com.poojan.fragmentgittask1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by VNurtureTechnologies on 03/02/17.
 */

public class FragmentLogIn extends Fragment {

    Button loginButton,cancelButton;

    LoggedInFragment loggedInFragment;

    EditText userET,passET;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment,container,false);

        loginButton=(Button) view.findViewById(R.id.login_button);
        cancelButton = (Button) view.findViewById(R.id.cancel_button);

        userET = (EditText) view.findViewById(R.id.edit_text_username);
        passET = (EditText) view.findViewById(R.id.edit_text_password);

        final String userName = "student@vnurture.com";
        final String password = "student@ks";



            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(userET.getText().toString().equals(userName) && passET.getText().toString().equals(password)) {

                    loggedInFragment = new LoggedInFragment();

                    FragmentManager fragmentManagerLoggedIn = getFragmentManager();
                    FragmentTransaction fragmentTransactionLoggedIn = fragmentManagerLoggedIn.beginTransaction();
                    fragmentTransactionLoggedIn.replace(R.id.linear_layout_log_in, loggedInFragment);
                    fragmentTransactionLoggedIn.addToBackStack(null);
                    fragmentTransactionLoggedIn.commit();
                }

                    else{

                        Toast.makeText(getActivity(), "Enter Correct Username and Password", Toast.LENGTH_SHORT).show();

                    }

                }
            });





        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.CATEGORY_HOME);
                startActivity(i);
            }
        });

        return view;
    }
}
