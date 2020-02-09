package com.rathana.fragment_demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.rathana.fragment_demo.fragment.CountryListFragment;
import com.rathana.fragment_demo.fragment.DetailFragment;

public class CountryActivity extends AppCompatActivity implements CountryListFragment.ItemClickCallback {

    static final String COUNTRY_LIST_FRAGMENT_TAG = "country_fragment";
    static final String COUNTRY_DETAIL_FRAGMENT_TAG = "country_detail_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        String name = "admin";
        String id = "ertyuicvbnm";

        CountryListFragment fragment = CountryListFragment.newInstance(name, id);
        fragment.setCallback(this);
        addFragment(fragment, COUNTRY_LIST_FRAGMENT_TAG);
    }

    private void addFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment, tag);
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragmentManager.findFragmentByTag(tag) != null)
            return;

        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onItemClicked(String item) {
        Log.e("@@@@", item);
        DetailFragment fragment = DetailFragment.newInstance(item);
        replaceFragment(fragment, COUNTRY_DETAIL_FRAGMENT_TAG);
    }


}
