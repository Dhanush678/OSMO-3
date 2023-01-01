package com.example.osmo_3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationBarView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.osmo_3.databinding.ActivityMainBinding;
import com.example.osmo_3.fragments.pagefragment1;
import com.example.osmo_3.fragments.pagefragment2;
import com.example.osmo_3.fragments.pagefragment3;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends DrawerBaseActivity {
    ActivityMainBinding activityMainBinding;
    private verticalviewpager viewpager;
    int counter =0;
    float x1,x2,y1,y2;
    private PagerAdapter pagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        List<Fragment> list = new ArrayList<>();
        list.add(new pagefragment1());
        list.add(new pagefragment2());
        list.add(new pagefragment3());

        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);

    }
}