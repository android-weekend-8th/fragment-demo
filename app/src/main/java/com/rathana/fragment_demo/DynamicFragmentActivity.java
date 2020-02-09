package com.rathana.fragment_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.rathana.fragment_demo.fragment.HomeFragment;
import com.rathana.fragment_demo.fragment.LoginFragment;
import com.rathana.fragment_demo.fragment.ReplaceFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    private Button buttonReplace, buttonRemove;

    static final String HOME_FRAGMENT = "home-fragment";
    static final String LOGIN_FRAGMENT = "login-fragment";
    static final String REPLACE_FRAGMENT = "replace-fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        buttonReplace = findViewById(R.id.buttonReplaceFragment);
        buttonRemove = findViewById(R.id.buttonRemoveFragment);

        HomeFragment homeFragment = HomeFragment.newInstance();
        LoginFragment loginFragment = LoginFragment.newInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.Container1, homeFragment, HOME_FRAGMENT);
        transaction.add(R.id.Container2, loginFragment, LOGIN_FRAGMENT);
        transaction.commit();

        buttonReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(ReplaceFragment.newInstance(), REPLACE_FRAGMENT);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment(REPLACE_FRAGMENT);
            }
        });
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment f = fragmentManager.findFragmentByTag(tag);
        if (f != null)
            return;

        transaction.replace(R.id.Container1, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void removeFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            return;
        }

        transaction.remove(fragment);
        transaction.commit();
    }

}
