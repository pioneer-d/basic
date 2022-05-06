package com.snaptag.labcode_china.navigation.scan.Sound;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

import com.snaptag.labcode_china.R;

import java.util.HashMap;

public class BeepSound {

    private static String thisName = "BeepSound";
    public static final int BEEP = R.raw.beep;

    private static SoundPool soundPool;


    public static void initSounds(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_ALARM,0);
        }
    }

    public static void beepPlay(){
        Log.d(thisName,"beepPlay() 실행");
        soundPool.play(BEEP,1,1,1,0,1f);
    }

}
