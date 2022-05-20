package com.snaptag.labcode_china.navigation.scan.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.scan.view.ScanControlFragment;


public class ControlSettingFragment extends Fragment {

    View view;
    ImageButton backButton, soundOnOff_button, vibrateOnOff_button;
    TextView camera_setting_text, sound, vibrate, soundOnOff, vibrateOnOff;

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
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_control_setting, container, false);

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
        soundOnOff.setText(R.string.txt_on);
        vibrateOnOff.setText(R.string.txt_on);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanControlFragment scanControlFragment = ScanControlFragment.newInstance();
                getParentFragmentManager().beginTransaction().remove(ControlSettingFragment.this).commit();
                scanControlFragment.onResume();
            }
        });

        return view;
    }
}