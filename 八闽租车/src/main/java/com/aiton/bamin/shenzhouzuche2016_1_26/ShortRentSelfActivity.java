package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ShortRentSelfActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_rent_self);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.checkCar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (v.getId()){
            case R.id.checkCar:
                intent.setClass(ShortRentSelfActivity.this,CheckCarActivity.class);
                startActivity(intent);
                break;
        }
    }
}
