package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.aiton.bamin.shenzhouzuche2016_1_26.fragment.ViewPagerFragment;

public class EnterpriseRentSelfActivity extends AppCompatActivity implements View.OnClickListener
{
    private ViewPager mViewPager;
    private int[] imgResID = new int[]{
            R.mipmap.normal01,
            R.mipmap.normal02,
            R.mipmap.normal03,
            R.mipmap.normal04
    };
    private Handler mHandler = new Handler();
    private Runnable mR;
    private boolean isViewPagerTouch = false;
    private ImageView mIv_rental;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_rent_self);

        initUI();
        setOnclick();
    }

    private void setOnclick()
    {
        mIv_rental.setOnClickListener(this);
    }

    private void initUI()
    {
        initBanner();
        mIv_rental = (ImageView) findViewById(R.id.iv_rental);
    }

    private void initBanner()
    {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);
        startViewpager();
        mViewPager.addOnPageChangeListener(new MyViewPagerListener());
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.iv_rental:
                intent.setClass(EnterpriseRentSelfActivity.this,EnterpriseReservationActivity.class);
                startActivity(intent);
                break;
        }
    }

    class MyViewPagerListener implements ViewPager.OnPageChangeListener
    {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }

        @Override
        public void onPageSelected(int position)
        {

        }

        @Override
        public void onPageScrollStateChanged(int state)
        {
            if (state == 1)
            {
                isViewPagerTouch = true;
            } else
            {
                isViewPagerTouch = false;
            }
            Log.e("onPageScrollSta", "onPageScrollStateCh" + state);
        }
    }

    private void startViewpager()
    {
        if (mR == null)
        {
            mR = new Runnable()
            {
                @Override
                public void run()
                {
                    if (!isViewPagerTouch)
                    {
                        int currentItem = mViewPager.getCurrentItem();
                        mViewPager.setCurrentItem(currentItem + 1);
                    }
                    mHandler.postDelayed(mR, 2000);
                }
            };
            mHandler.postDelayed(mR, 0);
        }
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter
    {

        public MyViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int i)
        {
            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
            viewPagerFragment.setImgRes(imgResID[i % 4]);
            return viewPagerFragment;
        }

        @Override
        public int getCount()
        {
            return Integer.MAX_VALUE;
        }
    }


}
