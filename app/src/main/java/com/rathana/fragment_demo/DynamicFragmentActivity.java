package com.rathana.fragment_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.rathana.fragment_demo.fragment.HomeFragment;
import com.rathana.fragment_demo.fragment.LoginFragment;
import com.rathana.fragment_demo.fragment.ReplaceFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    private Button buttonReplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        buttonReplace=findViewById(R.id.buttonReplaceFragment);

        HomeFragment homeFragment = HomeFragment.newInstance();
        LoginFragment loginFragment = LoginFragment.newInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.Container1, homeFragment, "home-fragment");
        transaction.add(R.id.Container2, loginFragment, "login-fragment");
        transaction.commit();

        buttonReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(ReplaceFragment.newInstance(),"replace");
            }
        });
    }


    private void replaceFragment(Fragment fragment,String tag){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Container1,fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
