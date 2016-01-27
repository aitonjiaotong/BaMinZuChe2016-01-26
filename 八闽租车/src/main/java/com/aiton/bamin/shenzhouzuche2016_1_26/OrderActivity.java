package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setClass(OrderActivity.this,RentSelfActivity.class);
            startActivity(intent);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    };
}
