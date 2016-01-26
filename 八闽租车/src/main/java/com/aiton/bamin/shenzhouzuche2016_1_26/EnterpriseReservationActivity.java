package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;

public class EnterpriseReservationActivity extends AppCompatActivity implements View.OnClickListener
{

    private LinearLayout mChooseCity;
    private TextView mTv_chooseCity;
    private LinearLayout mChooseCarModels;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_reservation);

        initUI();
        setOnclick();
    }

    private void initUI()
    {
        mChooseCity = (LinearLayout) findViewById(R.id.city_of_take_car);
        mChooseCarModels = (LinearLayout) findViewById(R.id.choose_car_models);
        mTv_chooseCity = (TextView) findViewById(R.id.tv_choose_city);

    }

    private void setOnclick()
    {
        mChooseCity.setOnClickListener(this);
        mChooseCarModels.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.city_of_take_car:
                intent.setClass(EnterpriseReservationActivity.this,ChooseCityActivity.class);
                startActivityForResult(intent, Constant.RequestCode.REQUEST_CODE_CHOOSE_CITY);
                break;
            case R.id.choose_car_models:
                intent.setClass(EnterpriseReservationActivity.this,CheckCarActivity.class);
                startActivityForResult(intent, Constant.RequestCode.REQUEST_CODE_CHOOSE_CAR);
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
                case Constant.RequestCode.REQUEST_CODE_CHOOSE_CITY:
                    if (resultCode == Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW)
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_SEARCH_LISTVIEW);
                        mTv_chooseCity.setText(chooseCity);
                    }else
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_CITY_LISTVIEW);
                        mTv_chooseCity.setText(chooseCity);
                    }
                    break;

            }
        }
    }
}
