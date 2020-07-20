package com.example.one_avtivity_multiple_fragments;

import android.app.Activity;
import android.content.Intent;
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
    RadioButton man, woman, calisiyor, calismiyor;
    Button addBtn;
    RadioGroup rGGender, rGworkingStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_add, container, false);
        defination();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (person.getText().toString().isEmpty() || !(isSelected(rGGender)) || !(isSelected(rGworkingStatus))) {
                    Toast.makeText(getActivity(), R.string.activity_add_screen_warningMessage, Toast.LENGTH_SHORT).show();

                } else {
                    Person.fullName=person.getText().toString();
                    if (man.isChecked()) {
                        Person.gender=R.drawable.man;
                    } else if (woman.isChecked()) {
                        Person.gender=R.drawable.woman;
                    }
                    if (calisiyor.isChecked()) {
                        Person.workingStatus=R.drawable.ic_action_calisiyor;
                    } else if (calismiyor.isChecked()) {
                        Person.workingStatus=R.drawable.ic_action_calismiyor;
                    }
                    ((MainActivity)getActivity()).kisiModels.add(new KisiModel(Person.fullName,Person.gender,Person.workingStatus));
                    ((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.activity_main_frameLayout,new PersonList(),"personListFragment")
                            .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                }

            }
        });
        return view;
    }
    public void defination() {
        person = view.findViewById(R.id.person);
        man = view.findViewById(R.id.man);
        woman = view.findViewById(R.id.woman);
        calisiyor = view.findViewById(R.id.calisiyor);
        calismiyor = view.findViewById(R.id.calismiyor);
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