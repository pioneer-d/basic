package com.snaptagScanner.china.navigation.scan.page;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.snaptagScanner.china.R;
import com.snaptagScanner.china.navigation.scan.view.ScanControlFragment;


public class ControlSettingFragment extends Fragment {

    static  String thisName = "ControlSettingFragment";

    View view;
    ImageButton backButton;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch soundOnOff_button, vibrateOnOff_button;
    TextView camera_setting_text, sound, vibrate, soundOnOff, vibrateOnOff;
    ScanControlFragment scanControlFragment;

    boolean soundDegree;
    boolean vibrateDegree;

    SharedPreferences mPref;

    public ControlSettingFragment() {
        // Required empty public constructor
    }

    public static ControlSettingFragment newInstance(String param1, String param2) {
        ControlSettingFragment fragment = new ControlSettingFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingSoundVibrate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_control_setting, container, false);

        settingSoundVibrate();

        backButton = view.findViewById(R.id.backButton);
        soundOnOff_button = view.findViewById(R.id.soundOnOff_button);
        vibrateOnOff_button = view.findViewById(R.id.vibrateOnOff_button);

        camera_setting_text = view.findViewById(R.id.camera_setting_text);
        sound = view.findViewById(R.id.sound);
        vibrate = view.findViewById(R.id.vibrate);
        soundOnOff = view.findViewById(R.id.soundOnOff);
        vibrateOnOff = view.findViewById(R.id.vibrateOnOff);

        camera_setting_text.setText(R.string.txt_camera_setting_text);
        sound.setText(R.string.txt_sound);
        vibrate.setText(R.string.txt_vibrate);

        soundOnOff_button.setChecked(soundDegree);
        vibrateOnOff_button.setChecked(vibrateDegree);

        if (soundDegree) {
            soundOnOff.setText(R.string.txt_on);
        } else {
            soundOnOff.setText(R.string.txt_off);
        }

        if (vibrateDegree){
            vibrateOnOff.setText(R.string.txt_on);
        } else {
            vibrateOnOff.setText(R.string.txt_off);
        }


        scanControlFragment = ScanControlFragment.newInstance();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().remove(ControlSettingFragment.this).commit();
                scanControlFragment.onResume();
            }
        });

        soundOnOff_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if (isChecked){
                    soundOnOff.setText(R.string.txt_on);
                    soundSet(true);
                    //scanControlFragment.volume = volume;
                } else {
                    soundOnOff.setText(R.string.txt_off);
                    soundSet(false);
                    //scanControlFragment.volume = 0;
                }
            }
        });

        vibrateOnOff_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if (isChecked){
                    vibrateOnOff.setText(R.string.txt_on);
                    vibrateSet(true);
                } else {
                    vibrateOnOff.setText(R.string.txt_off);
                    vibrateSet(false);
                }
            }
        });

        return view;
    }

    public void soundSet(boolean onOff){
        Log.d(thisName,"soundSet 설정");
        mPref = getActivity().getSharedPreferences("SOUND_PREF", getActivity().MODE_PRIVATE);
        boolean sound = onOff;
        mPref.edit().putString("SOUND_PREF", String.valueOf(sound)).apply();
    }

    public void vibrateSet(boolean onOff){
        Log.d(thisName,"vibrateSet 설정");
        mPref = getActivity().getSharedPreferences("VIBRATE_PREF", getActivity().MODE_PRIVATE);
        boolean vibrate = onOff;
        mPref.edit().putString("VIBRATE_PREF", String.valueOf(vibrate)).apply();
    }

    public void settingSoundVibrate(){
        mPref = getActivity().getSharedPreferences("SOUND_PREF", getActivity().MODE_PRIVATE);
        if (mPref.getString("SOUND_PREF", null) == null){
            soundDegree = true;
        }else {
            soundDegree = Boolean.parseBoolean(mPref.getString("SOUND_PREF", null));
        }
        Log.d(thisName,"soundDegree : "+String.valueOf(soundDegree));

        mPref = getActivity().getSharedPreferences("VIBRATE_PREF", getActivity().MODE_PRIVATE);
        if (mPref.getString("VIBRATE_PREF", null) == null){
            vibrateDegree = true;
        } else {
            vibrateDegree = Boolean.parseBoolean(mPref.getString("VIBRATE_PREF", null));
        }
    }

}