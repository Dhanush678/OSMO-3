package com.example.osmo_3;
import com.example.osmo_3.beyoundearth.earthfrag1;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.osmo_3.Mars_fragments.marsfrag3;
import com.example.osmo_3.beyoundearth.earthfrag1;
import com.example.osmo_3.beyoundearth.earthfrag2;


import com.example.osmo_3.databinding.ActivityEarthBinding;
import com.example.osmo_3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class earth extends DrawerBaseActivity  {
    ActivityEarthBinding activityEarthBinding;
    private verticalviewpager viewpager;
    int counter =0;
    float x1,x2,y1,y2;
    private PagerAdapter pagerAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth);

        activityEarthBinding = ActivityEarthBinding.inflate(getLayoutInflater());
        setContentView(activityEarthBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();


        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Fragment> list = new ArrayList<>();
        list.add(new earthfrag1());
        list.add(new earthfrag2());

        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(earth.this, categories.class));
        return;
    }

    public void playvideo(View view) {
        startActivity(new Intent(getApplicationContext(),videoplayer.class));
        finish();
    }
}