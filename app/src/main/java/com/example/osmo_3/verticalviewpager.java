package com.example.osmo_3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.viewpager.widget.ViewPager;

public class verticalviewpager extends ViewPager {
    public verticalviewpager(@NonNull Context context) {
        super(context);
    }

    public verticalviewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

        setPageTransformer(true , new Verticalpage());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    private MotionEvent getIntercombio(MotionEvent ev){
        float width =getWidth();
        float height =getHeight();
        float newX =(ev.getRawY()/ height)*width;
        float newY =(ev.getRawX()/ width)*height;
        ev.setLocation(newX,newY);
        return ev;}

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted =super.onInterceptTouchEvent(ev);
        getIntercombio(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(getIntercombio(ev));
    }
    private class Verticalpage implements ViewPager.PageTransformer{


        @Override
        public void transformPage(@NonNull View view, float position) {
            if (position < -1){
                view.setAlpha(0);
            }
            else if(position <=1){
                view.setAlpha(1);
                view.setTranslationX(view.getWidth() * -position);
                float yPosition =position * view.getHeight();
                view.setTranslationY(yPosition);
            }
            else{
                view.setAlpha(0);
            }
        }
    }
}
