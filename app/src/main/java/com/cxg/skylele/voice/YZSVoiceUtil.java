package com.cxg.skylele.voice;


import com.unisound.client.SpeechConstants;
import com.unisound.client.SpeechSynthesizer;
import com.unisound.client.SpeechSynthesizerListener;

/**
 * Created by cxg on 2018/4/26.
 * 云知声
 *
 * @version 1.0.0
 */

public class YZSVoiceUtil {
    private SpeechSynthesizer mTTSPlayer;

    public static YZSVoiceUtil getInstance() {
        return YZSVoiceUtilHolder.INSTANCE;
    }

    private static class YZSVoiceUtilHolder {
        private static final YZSVoiceUtil INSTANCE = new YZSVoiceUtil();
    }

    private YZSVoiceUtil() {
        mTTSPlayer = new SpeechSynthesizer(MyApplication.getInstance(), "em2vha6mfv3xgs4z2x4lg625m66j5e3wxhhcrpa4", "527d204bc4823cc9c4010a39e4829743");
        //2. 设置语音合成参数,设置语音合成模式为本地合成。更多识别参数的设置可以参考《云知声 USC API手册(Android)》

        mTTSPlayer.setOption(SpeechConstants.TTS_SERVICE_MODE, SpeechConstants.TTS_SERVICE_MODE_NET);
        //3. 设置回调监听
        mTTSPlayer.setTTSListener(new SpeechSynthesizerListener() {
            // 语音合成事件回调，支持的回调类型见5.3事件回调
            public void onEvent(int type) {
            }
            // 语音合成错误回调,错误输出格式及错误列表见附录。

            public void onError(int type, String errorMSG) {
            }
        });
        //4. 初始化语音合成引擎
        mTTSPlayer.init(null);
    }

    /**
     * 开始语音合成并播报
     *
     * @param msg
     */
    public void speak(String msg) {
        mTTSPlayer.playText(msg);
    }
}


