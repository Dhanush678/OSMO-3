package com.example.osmo_3;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class DrawerBaseActivity extends categories {
    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {

        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activitycontainer);
        container.addView(view);
        super.setContentView(drawerLayout);
        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout Human = findViewById(R.id.Human2);
        LinearLayout Earth = findViewById(R.id.earth2_0);
        CardView Energy = findViewById(R.id.Energy);
        Button back = findViewById(R.id.mainactivity);
        TextView terms;

        CardView beyoundearth = findViewById(R.id.Beyondearth);
        CardView Technology = findViewById(R.id.Technology);
        LinearLayout all = findViewById(R.id.all);
        CardView Cybersecurity = findViewById(R.id.Cybersecurity);
        CardView Mars = findViewById(R.id.Mars);
        CardView InformationAge = findViewById(R.id.InformationAge);
        CardView Startups = findViewById(R.id.Startups);
        CardView Future = findViewById(R.id.Future);

        NavigationView navigationView = drawerLayout.findViewById(R.id.navVIEW);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), human.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();

            }
        });
        Technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Technology.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        Mars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), mars.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        beyoundearth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), earth.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        Future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), futureclass.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });


        terms = findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TermsandConditions.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });


        TextView faq;
        faq = findViewById(R.id.FAQ);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FAQ.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        TextView privacy = findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), privacy.class));
                drawerLayout.closeDrawer(Gravity.LEFT,false);

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                onBackPressed();
            }
        });

    }

    protected void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }

    }

    @Override
    public void onBackPressed() {
        drawerLayout.closeDrawer(Gravity.LEFT, false);
    }
}