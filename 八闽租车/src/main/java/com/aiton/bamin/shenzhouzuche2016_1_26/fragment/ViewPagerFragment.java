package com.aiton.bamin.shenzhouzuche2016_1_26.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aiton.bamin.shenzhouzuche2016_1_26.R;

public class ViewPagerFragment extends Fragment {
private int ImgRes;
    private View mInflate;

    public void setImgRes(int ImgRes) {
        this.ImgRes=ImgRes;
        // Required empty public constructor
    }
public ViewPagerFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mInflate==null){
            mInflate = inflater.inflate(R.layout.fragment_view_pager, null);
            ImageView img = (ImageView) mInflate.findViewById(R.id.img);
            img.setImageResource(ImgRes);
        }
        return mInflate;
    }


}
