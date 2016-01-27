package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CheckServerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_server);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.nextStep).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (v.getId()){
            case R.id.nextStep:
                intent.setClass(CheckServerActivity.this,MakeSureOrder.class);
                startActivity(intent);
                break;
        }
    }
}
