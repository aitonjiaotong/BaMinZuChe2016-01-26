package com.aiton.bamin.shenzhouzuche2016_1_26.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.OrderActivity;
import com.aiton.bamin.shenzhouzuche2016_1_26.R;

public class PayActivity extends AppCompatActivity implements View.OnClickListener
{

    private TextView mTv_btn_confirm_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initUI();
        setOnclick();
    }

    private void initUI()
    {
        mTv_btn_confirm_pay = (TextView) findViewById(R.id.tv_btn_confirm_pay);
    }

    private void setOnclick()
    {
        mTv_btn_confirm_pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.tv_btn_confirm_pay:
                intent.setClass(PayActivity.this, OrderActivity.class);
                startActivity(intent);
                break;
        }
    }


}
