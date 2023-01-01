package com.example.osmo_3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.osmo_3.databinding.ActivityTestBinding;
import com.example.osmo_3.human_2.humanfrag1;

import java.util.ArrayList;
import java.util.List;

public class test extends DrawerBaseActivity {
    ActivityTestBinding activityTestBinding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTestBinding = activityTestBinding.inflate(getLayoutInflater());
        setContentView(activityTestBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Fragment> list = new ArrayList<>();
        list.add(new humanfrag1());

//
//        viewpager = findViewById(R.id.pager);
//        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
//        viewpager.setAdapter(pagerAdapter);
//        Button back = findViewById(R.id.next);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), categories.class));
//                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
//                finish();
//            }
//        });

    }

}