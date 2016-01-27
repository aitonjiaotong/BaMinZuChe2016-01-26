package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;

public class ShortRentSelfActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTakeCarCityTv;
    private TextView mReturnCarCityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_rent_self);
        initUI();
        setListener();
    }

    private void initUI() {
        mTakeCarCityTv = (TextView) findViewById(R.id.takeCarCityTv);
        mReturnCarCityTv = (TextView) findViewById(R.id.returnCarCityTv);
    }

    private void setListener() {
        findViewById(R.id.checkCar).setOnClickListener(this);
        findViewById(R.id.takeCarCity).setOnClickListener(this);
        findViewById(R.id.returnCarCity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (v.getId()){
            case R.id.checkCar:
                intent.setClass(ShortRentSelfActivity.this,CheckCarActivity.class);
                startActivity(intent);
                break;
            case R.id.takeCarCity:
                intent.setClass(ShortRentSelfActivity.this,ChooseCityActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.returnCarCity:
                intent.setClass(ShortRentSelfActivity.this,ChooseCityActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null)
        {
            switch (requestCode)
            {
                case 0:
                    if (resultCode == Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW)
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_SEARCH_LISTVIEW);
                        mTakeCarCityTv.setText(chooseCity);
                    }else
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_CITY_LISTVIEW);
                        mTakeCarCityTv.setText(chooseCity);
                    }
                    break;
                case 1:
                    if (resultCode == Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW)
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_SEARCH_LISTVIEW);
                        mReturnCarCityTv.setText(chooseCity);
                    }else
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_CITY_LISTVIEW);
                        mReturnCarCityTv.setText(chooseCity);
                    }
                    break;
            }
        }
    }
}
