package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.model.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class CheckCarActivity extends AppCompatActivity {

    private ListView mListView;
    private List<CarInfo> mCarInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_car);
        initUI();
        initData();
    }

    private void initData() {
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

    private void initUI() {
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        private ImageView mCarImg;
        private TextView mCarName;
        private TextView mCarPrice;

        @Override
        public int getCount() {
            return mCarInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.checkcar_list_item, null);
            mCarImg = (ImageView) inflate.findViewById(R.id.carImg);
            mCarName = (TextView) inflate.findViewById(R.id.carName);
            mCarPrice = (TextView) inflate.findViewById(R.id.carPrice);
            mCarImg.setImageResource(mCarInfoList.get(position).getCarImgID());
            mCarName.setText(mCarInfoList.get(position).getCarName());
            mCarPrice.setText(mCarInfoList.get(position).getCarPrice()+"");
            return inflate;
        }
    }
}
