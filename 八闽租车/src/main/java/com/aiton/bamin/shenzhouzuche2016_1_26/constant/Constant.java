package com.aiton.bamin.shenzhouzuche2016_1_26.constant;

/**
 * Created by Administrator on 2016/1/26.
 */
public class Constant
{
    public static class RequestCode
    {
        public static final int REQUEST_CODE_CHOOSE_CITY = 0;
        public static final int REQUEST_CODE_CHOOSE_CAR = 1;

        /**--***********返回码**********--*/
        public static final int RESULTCODE_LOCATION_ACTIVITY_SEARCH_LISTVIEW = 0;
        public static final int RESULTCODE_LOCATION_ACTIVITY_CITY_LISTVIEW = 1;
    }

    public static final class URL
    {
        public static final String HOST = "http://7xnuiw.com1.z0.glb.clouddn.com/";
        public static final String CITY_LIST_URL = HOST + "city.txt";
    }

    public static final class IntentKey
    {
        public static final String TITLE = "title";

        public static final String INTENT_KEY_SEARCH_LISTVIEW = "search_listview_key";
        public static final String INTENT_KEY_CITY_LISTVIEW = "city_listview_key";
    }


}
