package com.example.one_avtivity_multiple_fragments;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddFragment extends Fragment {
    View view;
    EditText person;
    RadioButton man, woman, working, notWorking;
    Button addBtn;
    RadioGroup rGGender, rGworkingStatus;
    String fullName;
    Integer gender;
    Integer workingStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add, container, false);

        defination();
        addButtonClick();

        return view;
    }

    private void addButtonClick() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (person.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.activity_add_screen_warningMessage_fullName, Toast.LENGTH_SHORT).show();
                } else if (!(isSelected(rGGender))) {
                    Toast.makeText(getActivity(), R.string.activity_add_screen_warningMessage_gender, Toast.LENGTH_SHORT).show();
                } else if (!(isSelected(rGworkingStatus))) {
                    Toast.makeText(getActivity(), R.string.activity_add_screen_warningMessage_workingStatus, Toast.LENGTH_SHORT).show();
                } else {
                    fullName = person.getText().toString();
                    if (man.isChecked()) {
                        gender = R.drawable.man;
                    } else if (woman.isChecked()) {
                        gender = R.drawable.woman;
                    }
                    if (working.isChecked()) {
                        workingStatus = R.drawable.ic_action_working;
                    } else if (notWorking.isChecked()) {
                        workingStatus = R.drawable.ic_action_notworking;
                    }
                    ((MainActivity) getActivity()).kisiModels.add(new KisiModel(fullName, gender, workingStatus));
                    ((MainActivity) getActivity()).backFirstFragment(getActivity());
                }

            }
        });
    }

    public void defination() {
        person = view.findViewById(R.id.person);
        man = view.findViewById(R.id.man);
        woman = view.findViewById(R.id.woman);
        working = view.findViewById(R.id.calisiyor);
        notWorking = view.findViewById(R.id.calismiyor);
        addBtn = view.findViewById(R.id.addBtn);
        rGGender = view.findViewById(R.id.rGGender);
        rGworkingStatus = view.findViewById(R.id.rGworkingStatus);
    }

    public boolean isSelected(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }
}