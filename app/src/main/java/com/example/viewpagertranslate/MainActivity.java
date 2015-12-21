package com.example.viewpagertranslate;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] mImgIds = new int[] { R.mipmap.addscene_type1,
            R.mipmap.addscene_type2, R.mipmap.addscene_type3,R.mipmap.addscene_type4,R.mipmap.addscene_type5,R.mipmap.addscene_type6};

    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    private MyViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vp = (MyViewPager) findViewById(R.id.vp);
        initData();
        init();
    }

    private void initData() {
        for(int i=0;i<mImgIds.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(mImgIds[i]);
            mImageViews.add(imageView);
        }
    }

    private void init() {
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mImageViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews.get(position));
            }
        });

        vp.setPageTransformer(true,new RotateDownPageTransformer());
    }
}
