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

import com.example.osmo_3.databinding.ActivityHumanBinding;
import com.example.osmo_3.human_2.humanfrag1;

import java.util.ArrayList;
import java.util.List;

public class human extends DrawerBaseActivity {
    ActivityHumanBinding activityHumanBinding;



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
        activityHumanBinding = activityHumanBinding.inflate(getLayoutInflater());
        setContentView(activityHumanBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Fragment> list = new ArrayList<>();
        list.add(new humanfrag1());


        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);

    }

}