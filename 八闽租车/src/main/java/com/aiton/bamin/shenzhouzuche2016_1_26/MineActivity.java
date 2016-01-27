package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MineActivity extends AppCompatActivity implements View.OnClickListener
{

    private TextView mTv_btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        initUI();
        setOnclick();
    }

    private void initUI()
    {
        mTv_btn_logout = (TextView) findViewById(R.id.tv_btn_logout);
    }

    private void setOnclick()
    {
        mTv_btn_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_btn_logout:

                break;
        }
    }

}
