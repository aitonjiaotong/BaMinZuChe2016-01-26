package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;
import com.aiton.bamin.shenzhouzuche2016_1_26.model.CarInfo;

public class EnterpriseReservationActivity extends AppCompatActivity implements View.OnClickListener
{

    private LinearLayout mChooseCity;
    private TextView mTv_chooseCity;
    private LinearLayout mChooseCarModels;
    private TextView mTv_chooseCarModels;
    private ImageView mAdd_count;
    private ImageView mMinus_count;
    private int mCount = 1;
    private TextView mTv_count;
    private TextView mTv_btn_next;

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
        mTv_chooseCarModels = (TextView) findViewById(R.id.tv_choose_car_model);
        mAdd_count = (ImageView) findViewById(R.id.add_count);
        mMinus_count = (ImageView) findViewById(R.id.minus_count);
        mTv_count = (TextView) findViewById(R.id.tv_count);
        mTv_btn_next = (TextView) findViewById(R.id.tv_btn_next);
    }

    private void setOnclick()
    {
        mChooseCity.setOnClickListener(this);
        mChooseCarModels.setOnClickListener(this);
        mAdd_count.setOnClickListener(this);
        mMinus_count.setOnClickListener(this);
        mTv_btn_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.city_of_take_car:
                intent.setClass(EnterpriseReservationActivity.this, ChooseCityActivity.class);
                startActivityForResult(intent, Constant.RequestCode.REQUEST_CODE_CHOOSE_CITY);
                break;
            case R.id.choose_car_models:
                intent.setClass(EnterpriseReservationActivity.this, EnterpriseCheckCarActivity.class);
                startActivityForResult(intent, Constant.RequestCode.REQUEST_CODE_CHOOSE_CAR);
                break;
            case R.id.add_count:
                mCount++;
                mTv_count.setText("" + mCount);
                if (mCount > 1)
                {
                    mMinus_count.setImageResource(R.mipmap.ic_count_minus_normal);
                    mMinus_count.setEnabled(true);
                }
                break;
            case R.id.minus_count:
                mCount--;
                mTv_count.setText("" + mCount);
                if (mCount == 1)
                {
                    mMinus_count.setEnabled(false);
                    mMinus_count.setImageResource(R.mipmap.ic_count_minus_disable);
                } else
                {
                    mMinus_count.setImageResource(R.mipmap.ic_count_minus_normal);
                    mMinus_count.setEnabled(true);
                }
                break;
            case R.id.tv_btn_next:
                intent.setClass(EnterpriseReservationActivity.this,EnterpriseConfirmOrderActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null)
        {
            switch (requestCode)
            {
                case Constant.RequestCode.REQUEST_CODE_CHOOSE_CITY:
                    if (resultCode == Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW)
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_SEARCH_LISTVIEW);
                        mTv_chooseCity.setText(chooseCity);
                    } else
                    {
                        String chooseCity = data.getStringExtra(Constant.IntentKey.INTENT_KEY_CITY_LISTVIEW);
                        mTv_chooseCity.setText(chooseCity);
                    }
                    break;
                case Constant.RequestCode.REQUEST_CODE_CHOOSE_CAR:
                    CarInfo choosed_car = (CarInfo) data.getSerializableExtra(Constant.IntentKey.INTENT_KEY_CHOOSE_CAR_MODEL);
                    mTv_chooseCarModels.setText(choosed_car.getCarName() + "|" + "三厢|1.6自动" + "|" + choosed_car.getCarPrice() + "/天");
            }
        }
    }
}
