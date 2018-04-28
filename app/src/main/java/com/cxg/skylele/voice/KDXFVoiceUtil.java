package com.cxg.skylele.voice;

import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.util.ResourceUtil;

/**
 * Created by cxg on 2018/4/26.
 *
 * @version 1.0.0
 */

public class KDXFVoiceUtil {
    private static SpeechSynthesizer mTts;

    public static void init() {
//            mTts.
//            mTts.setParameter( SpeechConstant.ENGINE_TYPE, engineType );
//            mTts.setParameter( SpeechConstant.ENGINE_MODE, engineMode );
//
//            if( SpeechConstant.TYPE_LOCAL.equals(engineType)
//                    &&SpeechConstant.MODE_MSC.equals(engineMode) ){
//                // 需下载使用对应的离线合成SDK
//                mTts.setParameter( ResourceUtil.TTS_RES_PATH, ttsResPath );
//            }
//
//            mTts.setParameter( SpeechConstant.VOICE_NAME, voiceName );
//
//            final String strTextToSpeech = "科大讯飞，让世界聆听我们的声音";
//            mTts.startSpeaking( strTextToSpeech, mSynListener );
//

        mTts = SpeechSynthesizer.createSynthesizer(MyApplication.getInstance(), null);
        mTts.setParameter(SpeechConstant.VOICE_NAME, "vixy"); //设置发音人
        // 0 小燕 青年女声 中英文（普通话） xiaoyan
        // 1 小宇 青年男声 中英文（普通话） xiaoyu
        // 2 凯瑟琳 青年女声 英文 catherine
        // 3 亨利 青年男声 英文 henry
        // 4 玛丽 青年女声 英文 vimary
        // 5 小研 青年女声 中英文（普通话） vixy
        // 6 小琪 青年女声 中英文（普通话） vixq xiaoqi
        // 7 小峰 青年男声 中英文（普通话） vixf
        // 8 小梅 青年女声 中英文（粤语） vixm xiaomei
        // 9 小莉 青年女声 中英文（台湾普通话） vixl xiaolin
        // 10 小蓉 青年女声 汉语（四川话） vixr xiaorong
        // 11 小芸 青年女声 汉语（东北话） vixyun xiaoqian
        // 12 小坤 青年男声 汉语（河南话） vixk xiaokun
        // 13 小强 青年男声 汉语（湖南话） vixqa xiaoqiang
        // 14 小莹 青年女声 汉语（陕西话） vixying
        // 15 小新 童年男声 汉语（普通话） vixx xiaoxin
        // 16 楠楠 童年女声 汉语（普通话） vinn nannan
        // 17 老孙 老年男声 汉语（普通话） vils
        mTts.setParameter(SpeechConstant.SPEED, "70"); //设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "100"); //设置音量，范围0~100
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端
    }

    public static void speak(String msg) {
        if (mTts == null) {
            init();
        }
        mTts.startSpeaking(msg, new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {
                i("onSpeakBegin");

            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {
                i("onBufferProgress");

            }

            @Override
            public void onSpeakPaused() {
                i("onSpeakPaused");

            }

            @Override
            public void onSpeakResumed() {
                i("onSpeakResumed");

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {
                i("onSpeakProgress" + " i: " + i + " ; i1 : " + i1 + " ; i2: " + i2);

            }

            @Override
            public void onCompleted(SpeechError speechError) {
                i("onCompleted" + speechError.toString());

            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {
                i("onEvent" + " i: " + i + " ; i1 : " + i1 + " ; i2: " + i2);

            }
        });
    }

    private static void i(String msg) {
        Log.i("KAXFVoiceUtil", msg);
    }
}
