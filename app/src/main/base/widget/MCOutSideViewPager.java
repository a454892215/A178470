/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.mobcent.discuz.base.widget;

import android.support.v4.view.ViewPager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MCOutSideViewPager extends ViewPager {
    private boolean mScrollEnable = true;
    
    public boolean ismScrollEnable() {
        return mScrollEnable;
    }
    
    public void setmScrollEnable(boolean mScrollEnable) {
        mScrollEnable = mScrollEnable;
    }
    
    public MCOutSideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public MCOutSideViewPager(Context context) {
        super(context);
    }
    
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            if(ismScrollEnable()) {
                return super.onTouchEvent(ev);
            }
        } catch(Exception localException1) {
        }
        return true;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent event) {
        try {
            if(ismScrollEnable()) {
                return super.onInterceptTouchEvent(event);
            }
        } catch(Exception localException1) {
        }
        return false;
    }
}
