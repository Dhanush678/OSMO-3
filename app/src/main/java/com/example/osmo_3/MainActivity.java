package com.example.osmo_3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationBarView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.osmo_3.databinding.ActivityMainBinding;
import com.example.osmo_3.fragments.pagefragment1;
import com.example.osmo_3.fragments.pagefragment2;
import com.example.osmo_3.fragments.pagefragment3;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends DrawerBaseActivity {
    ActivityMainBinding activityMainBinding;
    private verticalviewpager viewpager;
    int counter =0;
    float x1,x2,y1,y2;
    private PagerAdapter pagerAdapter;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ArrayList<String> title =new ArrayList<>();
    ArrayList<String> desc =new ArrayList<>();
    ArrayList<String> imagelink =new ArrayList<>();




DatabaseReference mRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){

        }



        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.mipmap.hamburger);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        mRef= FirebaseDatabase.getInstance().getReference("news");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot  ds: snapshot.getChildren()){
                    title.add(ds.child("title").getValue(String.class));
                    desc.add(ds.child("desc").getValue(String.class));
                    imagelink.add(ds.child("imagelink").getValue(String.class));



                }
                for (int i=0;i<imagelink.size();i++){
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        List<Fragment> list = new ArrayList<>();
        list.add(new pagefragment1());
        list.add(new pagefragment2());
        list.add(new pagefragment3());

        viewpager = findViewById(R.id.pager);
        pagerAdapter = new Vpageradapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);

    }
}