package com.example.one_avtivity_multiple_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PersonListFragment extends Fragment implements AdapterOnClick {
    View view;
    PersonalAdapter adp;
    FloatingActionButton fabBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_person_list, container, false);

        defination();
        createList();
        addButtonClick();


        return view;
    }

    private void addButtonClick() {
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFragment addFragment=new AddFragment();
                ((MainActivity)getActivity()).changeFragment(getContext(),addFragment,"addFragment");
            }
        });
    }

    public void defination() {
        fabBtn = view.findViewById(R.id.activity_main_add_floatActionButton);
        recyclerView = view.findViewById(R.id.activity_main_person_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createList() {
        adp = new PersonalAdapter(getContext(), ((MainActivity) getActivity()).kisiModels, this);
        recyclerView.setAdapter(adp);
    }


    @Override
    public void onClick(int position) {
        DeleteFragment deleteFragment = new DeleteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Utility.position, position);
        deleteFragment.setArguments(bundle);

        ((MainActivity)getActivity()).changeFragment(getContext(),deleteFragment,"deletefragment");

    }
}