package com.example.one_avtivity_multiple_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DeleteFragment extends Fragment {
    View view;
    TextView person;
    TextView gender;
    TextView workingStatus;
    Button delete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_delete, container, false);
        defination();
        seting();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).kisiModels.remove(Person.position);
                ((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_frameLayout,new PersonList(),"personListFragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        });







        return view;
    }

    public void seting() {
        person.setText(Person.fullName);
        if(Person.gender==R.drawable.man){
            gender.setText(R.string.common_man);
        }
        else if(Person.gender==R.drawable.woman){
            gender.setText(R.string.common_woman);
        }

        if(Person.workingStatus ==R.drawable.ic_action_calismiyor){
            workingStatus.setText(R.string.common_notWorking);
        }
        else if(Person.workingStatus==R.drawable.ic_action_calisiyor){
            workingStatus.setText(R.string.common_working);
        }
    }

    public void defination() {

        person=view.findViewById(R.id.activity_edit_screen_fullName_textView);
        gender=view.findViewById(R.id.activity_edit_screen_gender_TextView);
        workingStatus=view.findViewById(R.id.activity_edit_screen_workingSatatus_TextView);
        delete=view.findViewById(R.id.activity_edit_screen_removePerson_button);
    }
}