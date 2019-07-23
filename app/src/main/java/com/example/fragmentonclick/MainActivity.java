package com.example.fragmentonclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentInterface{

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayoutId);


        fragmentManager = getSupportFragmentManager();
        firstFragmentCall();
    }

    private void firstFragmentCall(){
        fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment fragment = new FirstFragment();
        fragmentTransaction.replace(R.id.frameLayoutId,fragment);
        fragmentTransaction.commit();
    }

    private void callSecondFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.frameLayoutId,secondFragment);
        fragmentTransaction.addToBackStack("F2");
        fragmentTransaction.commit();
    }

    @Override
    public void onClicked() {
        callSecondFragment();
    }
}
