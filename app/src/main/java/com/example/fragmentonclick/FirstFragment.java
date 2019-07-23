package com.example.fragmentonclick;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private FloatingActionButton floatingActionButton;
    private FirstFragmentInterface anInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.anInterface = (FirstFragmentInterface) context;
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        floatingActionButton = view.findViewById(R.id.fabId);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInterface.onClicked();
            }
        });
        return view;
    }

    interface FirstFragmentInterface{
        void onClicked();
    }

}
