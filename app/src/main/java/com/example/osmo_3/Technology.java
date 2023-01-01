package com.example.osmo_3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.osmo_3.databinding.ActivityEarthBinding;
import com.example.osmo_3.databinding.ActivityTechnologyBinding;
import com.example.osmo_3.fragments.pagefragment1;
import com.example.osmo_3.fragments.pagefragment2;
import com.example.osmo_3.fragments.pagefragment3;
import com.example.osmo_3.technology_fragments.techfragment1;
import com.example.osmo_3.technology_fragments.techfragment2;

import java.util.ArrayList;
import java.util.List;

public class Technology extends DrawerBaseActivity {
    private verticalviewpager viewpager;
    int counter =0;
    float x1,x2,y1,y2;
    private PagerAdapter pagerAdapter;


    @Override
    public void onBackPressed() {
        counter++;
        if(counter ==2){
            super.onBackPressed();
        }}
    ActivityTechnologyBinding activityTechnologyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTechnologyBinding = ActivityTechnologyBinding.inflate(getLayoutInflater());
        setContentView(activityTechnologyBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        List<Fragment> list = new ArrayList<>();
        list.add(new techfragment1());
        list.add(new techfragment2());

        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);

    }

}