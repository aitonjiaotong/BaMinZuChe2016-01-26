package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;

public class OrderActivity extends AppCompatActivity {

    private boolean mIsEnterprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initIntent();
    }

    private void initIntent()
    {
        Intent intent = getIntent();
        mIsEnterprise = intent.getBooleanExtra(Constant.IntentKey.INTENT_KEY_IS_ENTERPRISE, false);
    }

    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if(!mIsEnterprise)
            {
                intent.setClass(OrderActivity.this, RentSelfActivity.class);
            }else
            {
                intent.setClass(OrderActivity.this, EnterpriseRentSelfActivity.class);
            }

            startActivity(intent);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    };
}
