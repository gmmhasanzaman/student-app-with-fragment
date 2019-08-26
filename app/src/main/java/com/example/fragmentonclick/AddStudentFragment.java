package com.example.fragmentonclick;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentonclick.Model.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment {

    private EditText nameEt, phoneEt, addressEt;
    private Button saveBtn;
    private Context context;
    private StudentListListener listener;

    public AddStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (StudentListListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameEt = view.findViewById(R.id.nameET);
        phoneEt = view.findViewById(R.id.phoneET);
        addressEt = view.findViewById(R.id.addressET);
        saveBtn = view.findViewById(R.id.saveBtnId);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                String phone = phoneEt.getText().toString();
                String address = addressEt.getText().toString();

                Student student = new Student(name,phone,address);
                StoreClass.addStudent(student);

                // Go to StudentList
                listener.onSaveBtnClicked();
            }
        });
    }

    // Save Button Clicked
    public interface StudentListListener{
        void onSaveBtnClicked();
    }
}
