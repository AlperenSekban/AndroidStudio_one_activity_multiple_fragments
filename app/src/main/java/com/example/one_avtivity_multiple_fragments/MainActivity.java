package com.example.one_avtivity_multiple_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<KisiModel> kisiModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerThread.start();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_frameLayout,new SplashScreen(),"splashScrenFragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        createList();



    }
    public void createList() {

        kisiModels = new ArrayList<>();
        KisiModel k1 = new KisiModel("Alperen Sekban", R.drawable.man, R.drawable.ic_action_calismiyor);
        KisiModel k2 = new KisiModel("Derya Egeli", R.drawable.woman, R.drawable.ic_action_calisiyor);
        KisiModel k3 = new KisiModel("Recep Arslan", R.drawable.man, R.drawable.ic_action_calisiyor);
        KisiModel k4 = new KisiModel("Canan Kocadağ", R.drawable.woman, R.drawable.ic_action_calismiyor);
        KisiModel k5 = new KisiModel("Ahmet Çırak", R.drawable.man, R.drawable.ic_action_calismiyor);
        kisiModels.add(k1);
        kisiModels.add(k2);
        kisiModels.add(k3);
        kisiModels.add(k4);
        kisiModels.add(k5);
    }
    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{


                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_frameLayout,new PersonList(),"personListFragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        }
    };










}