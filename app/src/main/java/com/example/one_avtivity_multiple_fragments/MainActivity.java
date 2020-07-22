package com.example.one_avtivity_multiple_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<KisiModel> kisiModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment();
        createList();
    }

    private void firstFragment() {
        SplashScreen splashScreen=new SplashScreen();
        changeFragment(this,splashScreen,"splashScreenFragment");
    }

    public void createList() {

        kisiModels = new ArrayList<>();
        KisiModel k1 = new KisiModel("Alperen Sekban", R.drawable.man, R.drawable.ic_action_notworking);
        KisiModel k2 = new KisiModel("Derya Egeli", R.drawable.woman, R.drawable.ic_action_working);
        KisiModel k3 = new KisiModel("Recep Arslan", R.drawable.man, R.drawable.ic_action_working);
        KisiModel k4 = new KisiModel("Canan Kocadağ", R.drawable.woman, R.drawable.ic_action_notworking);
        KisiModel k5 = new KisiModel("Ahmet Çırak", R.drawable.man, R.drawable.ic_action_notworking);
        kisiModels.add(k1);
        kisiModels.add(k2);
        kisiModels.add(k3);
        kisiModels.add(k4);
        kisiModels.add(k5);
    }
    public void changeFragment(Context context, Fragment fragment, String tag){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_frameLayout,fragment,tag)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


    }

    public void backFirstFragment(Activity activity){
        ((FragmentActivity) activity).onBackPressed();
    }











}