package com.rathana.fragment_demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rathana.fragment_demo.R;

public class DetailFragment extends Fragment {

    private static final String ARG_COUNTRY_NAME = "arg_country";
    private TextView tvCountry;

    public static DetailFragment newInstance(String country) {
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY_NAME, country);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        tvCountry = view.findViewById(R.id.countryDetail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String country = getArguments().getString(ARG_COUNTRY_NAME);
        Log.e("@@", country);
        tvCountry.setText(country);
    }
}
