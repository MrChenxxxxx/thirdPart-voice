package com.cxg.skylele.voice;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by cxg on 2018/4/26.
 *
 * @version 1.0.0
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initVoice();
    }

    public static MyApplication getInstance() {
        return mInstance;
    }

    private void initVoice() {

        // 科大讯飞
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5ae193a3");

        // 云知声

    }
}
