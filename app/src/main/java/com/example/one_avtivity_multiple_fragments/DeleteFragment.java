package com.example.one_avtivity_multiple_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DeleteFragment extends Fragment implements SendDataFragment {
    View view;
    TextView personTextView;
    TextView genderTextView;
    TextView workingStatusTextView;
    Button deleteButton;
    int position;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delete, container, false);

        defination();
        seting();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).kisiModels.remove(position);
                ((MainActivity)getActivity()).backFirstFragment(getActivity());
            }
        });


        return view;
    }

    public void seting() {
        personTextView.setText(((MainActivity) getActivity()).kisiModels.get(position).getPerson());
        if (((MainActivity) getActivity()).kisiModels.get(position).getGender() == R.drawable.man) {
            genderTextView.setText(R.string.common_man);
        } else if (((MainActivity) getActivity()).kisiModels.get(position).getGender() == R.drawable.woman) {
            genderTextView.setText(R.string.common_woman);
        }

        if (((MainActivity) getActivity()).kisiModels.get(position).getWorkingstatus() == R.drawable.ic_action_notworking) {
            workingStatusTextView.setText(R.string.common_notWorking);
        } else if (((MainActivity) getActivity()).kisiModels.get(position).getWorkingstatus() == R.drawable.ic_action_working) {
            workingStatusTextView.setText(R.string.common_working);
        }
    }

    public void defination() {

        personTextView = view.findViewById(R.id.activity_edit_screen_fullName_textView);
        genderTextView = view.findViewById(R.id.activity_edit_screen_gender_TextView);
        workingStatusTextView = view.findViewById(R.id.activity_edit_screen_workingSatatus_TextView);
        deleteButton = view.findViewById(R.id.activity_edit_screen_removePerson_button);
        position = getArguments().getInt(Utility.position);


    }

    @Override
    public void sendData(int data) {
        this.position = data;
    }
}