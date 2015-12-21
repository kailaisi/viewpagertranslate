package com.example.viewpagertranslate;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by wu on 2015/12/21.
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    float MIN_SCALE=0.85f;
    float MIN_ALPHA=0.5f;

    @Override
    public void transformPage(View view, float position) {
        if(position<-1){
            ViewHelper.setAlpha(view,0);
        }else if(position<1){
            float percent=Math.max(MIN_SCALE,1-Math.abs(position));
            ViewHelper.setAlpha(view, 1);
            ViewHelper.setScaleX(view, percent);
            ViewHelper.setScaleY(view,percent);
        }else {
            view.setAlpha(0);
        }

    }
}
