package com.example.osmo_3;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.osmo_3.databinding.ActivityFutureclassBinding;
import com.example.osmo_3.future.futurefrag1;

import java.util.ArrayList;
import java.util.List;

public class futureclass extends DrawerBaseActivity {
    ActivityFutureclassBinding activityFutureclassBinding;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFutureclassBinding = ActivityFutureclassBinding.inflate(getLayoutInflater());
        setContentView(activityFutureclassBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        List<Fragment> list = new ArrayList<>();
        list.add(new futurefrag1());


        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);


    }


}