package com.aiton.bamin.shenzhouzuche2016_1_26;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aiton.bamin.shenzhouzuche2016_1_26.constant.Constant;
import com.aiton.bamin.shenzhouzuche2016_1_26.customview.LetterListView;
import com.aiton.bamin.shenzhouzuche2016_1_26.model.letter_list_city.Allcity;
import com.aiton.bamin.shenzhouzuche2016_1_26.model.letter_list_city.City;
import com.android.volley.VolleyError;
import com.github.volley.HTTPUtils;
import com.github.volley.VolleyListener;
import com.xmbc.utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mIv_back;

    private ListView mListView;
    private TextView tv_mLetter;

//    private List<Hotcity> mHotcity = new ArrayList<Hotcity>();
    private List<Allcity> mAllcity = new ArrayList<Allcity>();
    private List<Allcity> mSearchcity = new ArrayList<Allcity>();
    private MyListAdapter mAdapter;
    private ImageView tv_mBack;
    private ListView mSearchListView;
    private EditText mSearchEdit;
    private SearchListAdapter mSearchAdapter;
    private ImageView mSearchClear;
    private String mUser_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        initUI();
        setOnclick();
        initData();
    }

    private void initData()
    {
        HTTPUtils.get(this, Constant.URL.CITY_LIST_URL, new VolleyListener()
        {
            public void onResponse(String arg0)
            {
                City city = GsonUtils.parseJSON(arg0, City.class);
                mAllcity = city.getAllcity();
                mAdapter.notifyDataSetChanged();
            }
            public void onErrorResponse(VolleyError arg0)
            {
            }
        });
    }


    private void initUI() {

        mIv_back = (ImageView) findViewById(R.id.iv_back);
        initLetterListView();
    }

    private void initLetterListView() {
        /**---*************搜索结果显示的ListView******************---**/
        mSearchListView = (ListView) this.findViewById(R.id.lv_list_citys_for_search);
        mSearchListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent data = new Intent();
                if(mSearchcity != null && mSearchcity.size() > 0)
                {
                    data.putExtra(Constant.IntentKey.INTENT_KEY_SEARCH_LISTVIEW, mSearchcity.get(position).getName());
                }
                setResult(Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW, data );
                finish();
            }
        });
        mSearchAdapter = new SearchListAdapter();
        mSearchListView.setAdapter(mSearchAdapter);

        mSearchClear = (ImageView) this.findViewById(R.id.iv_clear);
        mSearchClear.setOnClickListener(this);

        mSearchEdit = (EditText) this.findViewById(R.id.et_search_city);
        TextWatcher watcher = new MyTextWatcher();
        mSearchEdit.addTextChangedListener(watcher);

        tv_mBack = (ImageView) this.findViewById(R.id.iv_back);
        tv_mBack.setOnClickListener(this);

        mListView = (ListView) this.findViewById(R.id.lv_list_citys);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent data = new Intent();
                if(mAllcity != null && mAllcity.size() > 0)
                {
                    data.putExtra(Constant.IntentKey.INTENT_KEY_CITY_LISTVIEW, mAllcity.get(position).getName());
                }
                setResult(Constant.RequestCode.RESULTCODE_LOCATION_ACTIVITY_CITY_LISTVIEW, data );
                finish();
            }
        });
        tv_mLetter = (TextView) this.findViewById(R.id.tv_letter);
        LetterListView mIndexList_Letter = (LetterListView) this.findViewById(R.id.letter_listview);
        mIndexList_Letter.setOnGetLetterListener(new LetterListView.GetLetterListener()
        {
            @Override
            public void onLetterChanged(String letter)
            {
                tv_mLetter.setVisibility(View.VISIBLE);
                tv_mLetter.setText(letter);
                //更新ListView的行数显示
                int searchLetter_index = searchLetter(letter);
                mListView.setSelection(searchLetter_index);
            }
            @Override
            public void onActionUp()
            {
                tv_mLetter.setVisibility(View.GONE);
            }
        });

        mAdapter = new MyListAdapter();
        mListView.setAdapter(mAdapter);
    }

    private void setOnclick() {
        mIv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_clear:
                mSearchEdit.setText("");
                mSearchcity.clear();
                mSearchAdapter.notifyDataSetChanged();
                break;
        }
    }


    class MyListAdapter extends BaseAdapter {

        private View layout;

        public int getCount() {
            return mAllcity.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layout = getLayoutInflater().inflate(R.layout.list_item_city, null);
            TextView tv_fristletter = (TextView) layout.findViewById(R.id.tv_fristletter);
            TextView tv_city = (TextView) layout.findViewById(R.id.tv_city);

            tv_city.setText(mAllcity.get(position).getName());
            //当前行首字母
            String substring_fristletter = mAllcity.get(position).getPinyin().substring(0, 1);
            tv_fristletter.setText(substring_fristletter.toUpperCase());

            if (position > 0) {
                //上一行首字母
                String lastletter = mAllcity.get(position - 1).getPinyin().substring(0, 1);
                if (substring_fristletter.equals(lastletter)) {
                    tv_fristletter.setVisibility(View.GONE);
                }
            }

            return layout;
        }

    }

    class SearchListAdapter extends BaseAdapter
    {
        public int getCount()
        {
            return mSearchcity.size();
        }

        public Object getItem(int position)
        {
            return null;
        }

        public long getItemId(int position)
        {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View layout = getLayoutInflater().inflate(R.layout.list_item_search_city, null);
            TextView search_city_name = (TextView) layout.findViewById(R.id.tv_search_city);

            if(mSearchcity != null && mSearchcity.size() > 0)
            {
//				search_city_name.setText(mSearchcity.get(position).getName());

                String name = mSearchcity.get(position).getName();
                if (name.startsWith(mUser_input)){
                    SpannableStringBuilder builder = new SpannableStringBuilder(name);
                    ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.parseColor("#ff06c1ae"));
                    builder.setSpan(greenSpan, 0, mUser_input.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    search_city_name.setText(builder);
                }else{
                    search_city_name.setText(name);
                }
            }
            return layout;
        }
    }

    class MyTextWatcher implements TextWatcher
    {
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            mUser_input = s.toString();
            if("".equals(mUser_input))
            {
                mSearchClear.setVisibility(View.GONE);
                mSearchListView.setVisibility(View.GONE);
            }else
            {
                mSearchClear.setVisibility(View.VISIBLE);
                mSearchListView.setVisibility(View.VISIBLE);
                mSearchcity.clear();
                mSearchAdapter.notifyDataSetChanged();
                for (int i = 0; i < mAllcity.size(); i++)
                {
                    Allcity allcity = mAllcity.get(i);
                    if(allcity.getName().startsWith(mUser_input.trim()) || allcity.getPinyin().startsWith(mUser_input.trim()))
                    {
                        mSearchcity.add(allcity);
                        mSearchAdapter.notifyDataSetChanged();
                    }
                }
            }
        }

        public void afterTextChanged(Editable s)
        {

        }
    }

    //搜索用户点击自定义的IndexListView控件所返回的字母
    public int searchLetter(String letter)
    {
        for (int i = 0; i < mAllcity.size(); i++)
        {
            String string = mAllcity.get(i).getPinyin();
            if(string.toUpperCase().startsWith(letter))
            {
                return i;
            }
        }
        return -1;
    }
}
