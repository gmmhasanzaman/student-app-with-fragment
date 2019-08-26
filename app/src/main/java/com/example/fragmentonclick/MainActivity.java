package com.example.fragmentonclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements StudentListFragment.AddStudentListListener,
        AddStudentFragment.StudentListListener {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayoutId);


        fragmentManager = getSupportFragmentManager();
        //StudentListFragmentCall();
        fragmentTransaction = fragmentManager.beginTransaction();
        StudentListFragment studentListFragment = new StudentListFragment();
        fragmentTransaction.add(R.id.frameLayoutId,studentListFragment);
        fragmentTransaction.commit();
    }

    private void addStudentFragmentCall(){
        fragmentTransaction = fragmentManager.beginTransaction();
        AddStudentFragment addStudentFragment = new AddStudentFragment();
        fragmentTransaction.replace(R.id.frameLayoutId, addStudentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void StudentListFragmentCall(){
        fragmentTransaction = fragmentManager.beginTransaction();
        StudentListFragment fragment = new StudentListFragment();
        fragmentTransaction.replace(R.id.frameLayoutId,fragment);
        fragmentTransaction.commit();
    }

    // StudentList to AddStudent Fragment
    @Override
    public void onAddBtnClicked() {
        addStudentFragmentCall();
    }

    @Override
    public void onSaveBtnClicked() {
        StudentListFragmentCall();
    }

}
