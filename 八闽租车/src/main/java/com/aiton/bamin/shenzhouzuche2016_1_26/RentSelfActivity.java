package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.aiton.bamin.shenzhouzuche2016_1_26.banner.SimpleImageBanner;
import com.flyco.pageindicator.indicator.FlycoPageIndicaor;

import java.util.ArrayList;

public class RentSelfActivity extends AppCompatActivity implements View.OnClickListener {

//    private ViewPager mViewPager;
    private int[] imgResID = new int[]{
            R.mipmap.normal01,
            R.mipmap.normal02,
            R.mipmap.normal03,
            R.mipmap.normal04
    };
    private SimpleImageBanner banner;
    private ArrayList<Integer> resList;
//    private Handler mHandler = new Handler();
//    private Runnable mR;
//    private boolean isViewPagerTouch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_self);
        initUI();
        setListener();
    }

    private void setListener() {
//        mViewPager.addOnPageChangeListener(new MyViewPagerListener());
        findViewById(R.id.main_short).setOnClickListener(this);
        findViewById(R.id.kefu).setOnClickListener(this);
        findViewById(R.id.mine).setOnClickListener(this);
    }

    private void initUI() {
//        mViewPager = (ViewPager) findViewById(R.id.viewPager);
//        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
//        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);
//        startViewpager();
        resList = new ArrayList<>();
        for (int i = 0; i < imgResID.length; i++) {
            resList.add(imgResID[i]);
        }
        banner = (SimpleImageBanner) findViewById(R.id.banner);
        banner.setSource(resList).startScroll();
        FlycoPageIndicaor indicator = (FlycoPageIndicaor) findViewById(R.id.indicator_circle_stroke);
        indicator.setViewPager(banner.getViewPager(), resList.size());
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (v.getId()){
            case R.id.main_short:
                intent.setClass(RentSelfActivity.this, ShortRentSelfActivity.class);
                startActivity(intent);
                break;
            case R.id.kefu:
                Intent intent_call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
                startActivity(intent_call);
                break;
            case R.id.mine:
                intent.setClass(RentSelfActivity.this,MineActivity.class);
                startActivity(intent);
                break;
        }
    }

//    class MyViewPagerListener implements ViewPager.OnPageChangeListener{
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//            if (state==1){
//                isViewPagerTouch=true;
//            }else {
//                isViewPagerTouch=false;
//            }
//            Log.e("onPageScrollSta", "onPageScrollStateCh"+state);
//        }
//    }
//
//    private void startViewpager() {
//        if (mR==null){
//            mR = new Runnable() {
//                @Override
//                public void run() {
//                    if (!isViewPagerTouch){
//                        int currentItem = mViewPager.getCurrentItem();
//                        mViewPager.setCurrentItem(currentItem+1);
//                    }
//                    mHandler.postDelayed(mR,2000);
//                }
//            }; mHandler.postDelayed(mR,0);
//        }
//    }

//    class MyViewPagerAdapter extends FragmentPagerAdapter {
//
//        public MyViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
//            viewPagerFragment.setImgRes(imgResID[i%4]);
//            return viewPagerFragment;
//        }
//
//        @Override
//        public int getCount() {
//            return Integer.MAX_VALUE;
//        }
//    }
    private long currentTime = 0;
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis()-currentTime>1000){
                Toast toast = Toast.makeText(RentSelfActivity.this, "双击退出应用", Toast.LENGTH_SHORT);
                toast.show();
                currentTime=System.currentTimeMillis();
                return false;
            }else{
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    };
}
