package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;

public class EnterpriseConfirmOrderActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button mBtn_makeSure;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_confirm_order);

        initUI();
        setOnclick();
    }

    private void initUI()
    {
        mBtn_makeSure = (Button) findViewById(R.id.makeSure);

    }

    private void setOnclick()
    {
        mBtn_makeSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.makeSure:
                intent.setClass(EnterpriseConfirmOrderActivity.this,OrderActivity.class);
                boolean isEnterprise = true;
                intent.putExtra(Constant.IntentKey.INTENT_KEY_IS_ENTERPRISE,isEnterprise);
                startActivity(intent);
                finish();
                break;
        }
    }
}
