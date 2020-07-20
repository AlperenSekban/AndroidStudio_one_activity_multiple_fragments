package com.example.one_avtivity_multiple_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PersonList extends Fragment {
    View view;
    Adapter adp;
    FloatingActionButton fabBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_person_list, container, false);
        defination();

        createList();
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_frameLayout,new AddFragment(),"addFragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack("personListFragment")
                        .commit();
            }
        });


        return view;
    }

    public void defination() {
        fabBtn = view.findViewById(R.id.activity_main_add_floatActionButton);
        recyclerView = view.findViewById(R.id.activity_main_person_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createList() {
        adp = new Adapter(this.getContext(),
                ((MainActivity)getActivity()).kisiModels);
        recyclerView.setAdapter(adp);
    }




}