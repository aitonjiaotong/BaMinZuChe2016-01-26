package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aiton.bamin.shenzhouzuche2016_1_26.model.PayActivity;

public class MakeSureOrder extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_sure_order);
        setListener();
    }

    private void setListener()
    {
        findViewById(R.id.makeSure).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.makeSure:
                intent.setClass(MakeSureOrder.this, PayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
