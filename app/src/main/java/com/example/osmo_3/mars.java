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

import com.example.osmo_3.Mars_fragments.marsfrag1;
import com.example.osmo_3.Mars_fragments.marsfrag2;
import com.example.osmo_3.Mars_fragments.marsfrag3;
import com.example.osmo_3.databinding.ActivityFutureclassBinding;
import com.example.osmo_3.databinding.ActivityMarsBinding;
import com.example.osmo_3.fragments.pagefragment1;
import com.example.osmo_3.fragments.pagefragment2;
import com.example.osmo_3.fragments.pagefragment3;
import com.example.osmo_3.technology_fragments.techfragment1;
import com.example.osmo_3.technology_fragments.techfragment2;

import java.util.ArrayList;
import java.util.List;

public class mars extends DrawerBaseActivity {
    ActivityMarsBinding activityMarsBinding;
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
        activityMarsBinding = ActivityMarsBinding.inflate(getLayoutInflater());
        setContentView(activityMarsBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburgersec);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        List<Fragment> list = new ArrayList<>();
        list.add(new marsfrag1());
        list.add(new marsfrag2());
        list.add(new marsfrag3());

        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);


    }
    public boolean onTouchEvent(MotionEvent touchEvent){

        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    startActivity(new Intent(getApplicationContext(),categories.class));
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    finish();

                }

        }
        return false;
    }

}