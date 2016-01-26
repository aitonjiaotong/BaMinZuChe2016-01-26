package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private Boolean mIsPersonalLogin = true;
    private TextView mTv_register;
    private TextView mTv_personalLogin;
    private TextView mTv_enterpriseLogin;
    private EditText mEt_loginNumber;
    private TextView mTv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        setOnclick();
    }

    private void initUI()
    {
        mTv_register = (TextView) findViewById(R.id.tv_register);
        mTv_personalLogin = (TextView) findViewById(R.id.tv_personal_login);
        mTv_enterpriseLogin = (TextView) findViewById(R.id.tv_enterprise_login);
        mEt_loginNumber = (EditText) findViewById(R.id.et_account_login_number);
        mTv_login = (TextView) findViewById(R.id.tv_btn_login);
    }

    private void setOnclick()
    {
        mTv_register.setOnClickListener(this);
        mTv_personalLogin.setOnClickListener(this);
        mTv_enterpriseLogin.setOnClickListener(this);
        mTv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.tv_register:
                if(mIsPersonalLogin)
                {
                    intent.setClass(LoginActivity.this,RegisterSelfActivity.class);
                    startActivity(intent);
                }else
                {
                    intent.setClass(LoginActivity.this,EnterpriseActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_personal_login:
                mIsPersonalLogin = true;
                setTab(mIsPersonalLogin);
                break;
            case R.id.tv_enterprise_login:
                mIsPersonalLogin = false;
                setTab(mIsPersonalLogin);
                break;
            case R.id.tv_btn_login:
                if(mIsPersonalLogin)
                {
                    //个人租车登陆
                    intent.setClass(LoginActivity.this,RentSelfActivity.class);
                    startActivity(intent);
                    finish();
                }else
                {
                    //政企租车登陆
                    intent.setClass(LoginActivity.this,EnterpriseRentSelfActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }

    public void setTab(boolean isPersonalLogin)
    {
        if(isPersonalLogin)
        {
            mTv_personalLogin.setBackgroundResource(R.mipmap.tab_left_checked);
            mTv_enterpriseLogin.setBackgroundResource(R.mipmap.tab_right_nor);
            mTv_register.setText("注册个人会员");
            mEt_loginNumber.setHint("请输入手机号");
        }else
        {
            mTv_personalLogin.setBackgroundResource(R.mipmap.tab_left_nor);
            mTv_enterpriseLogin.setBackgroundResource(R.mipmap.tab_right_checked);
            mTv_register.setText("注册政企会员");
            mEt_loginNumber.setHint("请输入政企账号");
        }
    }
}
