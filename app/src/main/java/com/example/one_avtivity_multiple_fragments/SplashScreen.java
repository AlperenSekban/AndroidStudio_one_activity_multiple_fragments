package com.example.one_avtivity_multiple_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_splash_screen, container, false);
        bekle();


        return view;





    }

    private void bekle() {

        Thread thread=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                    PersonListFragment personListFragment=new PersonListFragment();
                    ((MainActivity)getActivity()).changeFragment(getActivity(),personListFragment,"personListFragment");
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}