package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;
import com.aiton.bamin.shenzhouzuche2016_1_26.model.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseCheckCarActivity extends AppCompatActivity
{

    private ListView mLv_carType;
    private List<CarInfo> mCarInfoList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_check_car);
        initUI();
        initData();
        setOnclick();
    }

    private void initUI()
    {
        initListViewForCarType();

    }

    private void initListViewForCarType()
    {
        mLv_carType = (ListView) findViewById(R.id.lv_car_type);
        mAdapter = new MyAdapter();
        mLv_carType.setAdapter(mAdapter);
    }

    private void initData()
    {
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal01, "起亚K2", 132));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal02, "别克凯越", 157));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal03, "本田飞度", 169));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal01, "起亚K2", 132));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal02, "别克凯越", 157));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal03, "本田飞度", 169));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal01, "起亚K2", 132));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal02, "别克凯越", 157));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal03, "本田飞度", 169));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal01, "起亚K2", 132));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal02, "别克凯越", 157));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal03, "本田飞度", 169));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal01, "起亚K2", 132));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal02, "别克凯越", 157));
        mCarInfoList.add(new CarInfo(R.mipmap.check_normal03, "本田飞度", 169));
    }

    private void setOnclick()
    {
        mLv_carType.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent data = new Intent();
                data.putExtra(Constant.IntentKey.INTENT_KEY_CHOOSE_CAR_MODEL,mCarInfoList.get(position));
                setResult(Constant.RequestCode.RESULTCODE_CHOOSE_CAR_MODEL,data);
                finish();
            }
        });
    }

    class MyAdapter extends BaseAdapter
    {
        private ImageView mCarImg;
        private TextView mCarName;
        private TextView mCarPrice;
        @Override
        public int getCount()
        {
            return mCarInfoList.size();
        }
        @Override
        public Object getItem(int position)
        {
            return null;
        }
        @Override
        public long getItemId(int position)
        {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View inflate = getLayoutInflater().inflate(R.layout.checkcar_list_item, null);
            mCarImg = (ImageView) inflate.findViewById(R.id.carImg);
            mCarName = (TextView) inflate.findViewById(R.id.carName);
            mCarPrice = (TextView) inflate.findViewById(R.id.carPrice);
            mCarImg.setImageResource(mCarInfoList.get(position).getCarImgID());
            mCarName.setText(mCarInfoList.get(position).getCarName());
            mCarPrice.setText(mCarInfoList.get(position).getCarPrice() + "");
            return inflate;
        }
    }

}
