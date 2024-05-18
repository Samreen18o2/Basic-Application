package com.example.basicapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SampleFragment extends Fragment {

    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        // Access views in the fragment layout if needed
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("This is a Fragment ");

        return view;
    }
}

