package com.snaptag.labcode_china.navigation.scan.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.snaptag.cameramodule.STCameraView;
import com.snaptag.cameramodule.model.DetectResult;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.api.Post;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.scan.frg.AlertTimeFragment;
import com.snaptag.labcode_china.navigation.scan.frg.ScanSuccessFragment;
import com.snaptag.labcode_china.navigation.scan.model.CameraData;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanPresenter;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ScanControlFragment_Test extends Fragment implements View.OnClickListener, STCameraView.OnDetectResultListener {

    private static ScanControlFragment_Test instance;
    private ScanControlFragment_Test() { }

    private static String thisName = "ScanControlFragment_Test";

    private View view;
    private STCameraView stCameraView = null;
    private ImageButton flashButton, flashButton2, zoom, zoom_more, zoom_1_0, zoom_1_5, zoom_2_0;
    private TextView guideText;

    //Timer 관련
    private Timer timer;
    private TimerTask task;
    int onGoingTime = 0;
    private boolean isCancel = false;

    //sound관련
    SoundPool soundPool;
    private int soundManage;

    //vibrate 관련
    Vibrator vibrator;


    //API 관련
    private Button testButton;
    private FrameLayout zoomBox;
    private MutableLiveData detectResult = new MutableLiveData<DetectResult>();
    static String BASEURL = "https://admin.labcode.kr/";

    //page이동
    private Fragment successFragment;
    private Fragment alertTimeFragment;

    private boolean flashClick = false;
    private boolean zoomClick = false;

    private ScanContract.Presenter presenter;
    CameraData data;

    public static ScanControlFragment_Test newInstance() {
        if(instance == null){
            instance = new ScanControlFragment_Test();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
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
        view = inflater.inflate(R.layout.fragment_scan_control__test, container, false);

        stCameraView = (STCameraView) view.findViewById(R.id.st_camera);

        flashButton = view.findViewById(R.id.flash);
        flashButton2 = view.findViewById(R.id.flash2);
        zoom = view.findViewById(R.id.zoom);
        zoom_more = view.findViewById(R.id.zoom_more);
        zoomBox = view.findViewById(R.id.zoom_box);
        zoom_1_0 = view.findViewById(R.id.zoom_1_0);
        zoom_1_5 = view.findViewById(R.id.zoom_1_5);
        zoom_2_0 = view.findViewById(R.id.zoom_2_0);

        //API 관련
        testButton = view.findViewById(R.id.testButton);
        guideText = view.findViewById(R.id.guideText);

        flashButton.setOnClickListener(this);
        flashButton2.setOnClickListener(this);
        zoom.setOnClickListener(this);
        zoom_more.setOnClickListener(this);
        zoom_1_0.setOnClickListener(this);
        zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
        zoom_1_5.setOnClickListener(this);
        zoom_2_0.setOnClickListener(this);
        testButton.setOnClickListener(this);

        //BeepSound.initSounds(getContext());

        data = CameraData.getInstance();
        //presenter = new ScanPresenter(this,getActivity(),textureView);
        initCameraModule();
        return view;
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.flash : case R.id.flash2 :
                flashClick = (flashClick == false) ? true : false;
                if (flashClick == true) {stCameraView.setFlash(true);}
                else {stCameraView.setFlash(false);}
                break;
            case R.id.zoom: case R.id.zoom_more:
                zoomClick = (zoomClick == true) ? false : true;
                if (zoomClick == true) {
                    zoom.setImageResource(R.drawable.ic_filled_circle);
                    zoomBox.setVisibility(View.VISIBLE);
                } else {
                    zoom.setImageResource(R.drawable.ic_blanked_circle);
                    zoomBox.setVisibility(View.INVISIBLE);
                } break;
            case R.id.zoom_1_0: zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(1.0f);
                stCameraView.setZoom(data.getZoomRate());
                break;
            case R.id.zoom_1_5: zoom_1_5.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(1.5f);
                stCameraView.setZoom(data.getZoomRate());
                break;
            case R.id.zoom_2_0: zoom_2_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(2.0f);
                stCameraView.setZoom(data.getZoomRate());
                break;
        }


    }

    private void initCameraModule(){
        stCameraView.setDetectListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(thisName,"onResume() 실행");
        Log.d(thisName,"getUuid()"+getUuid());

        if (stCameraView != null){
            stCameraView.setStartZoom(1.0f);
            stCameraView.setFlash(false);
            Log.d(thisName,"stDetectStart() 실행직전");
            stCameraView.stDetectStart();
        }
        onGoingTime = 0;
        startTimer();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(thisName,"onPause() 실행");
        stCameraView.stDetectStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(thisName,"onDestroy() 실행");
        stopTimer();
    }

    //-> go to presenter
    private void startTimer(){
        Log.d(thisName,"startTimer() 실행");

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                onGoingTime++;
                Log.d(thisName,"onGoingTime : "+String.valueOf(onGoingTime));

                if (onGoingTime % 9 == 0){
                    guideText.setText(R.string.txt_scan_guide_first);
                } else if (onGoingTime % 9 == 3){
                    guideText.setText(R.string.txt_scan_guide_second);
                } else if (onGoingTime % 9 == 6){
                    guideText.setText(R.string.txt_scan_guide_third);
                }
                if (onGoingTime == 5){
                    stopTimer();
                }

            }
        };
        timer.schedule(task,0,1000);
    }

    private void stopTimer(){
        Log.d(thisName,"stopTimer() 실행");
        timer.cancel();
        if (onGoingTime == 5){
            goAlertTime();
        }
    }

    @Override
    public void getDetectResult(JsonObject jsonObject) {

    }

    @Override
    public void getDetectResult(DetectResult detectResult) {
        //if (it.getResultType() == DetectResult.DETECTSUCCESS) ??
        Log.d(thisName,"getDetectResult() 실행");
        if (detectResult != null){
            Log.d(thisName,"getDetectResult() 내부 detectResult != null() ");
            Log.d(thisName,"detectResult : "+detectResult);
            this.detectResult.setValue(detectResult);
            Log.d(thisName,String.valueOf(this.detectResult.getValue()));
            goToResult((DetectResult) this.detectResult.getValue());
        }
    }

    //-> goToPresenter or Model
    private void  goToResult(DetectResult detectResult){
        Log.d(thisName,"goToResult() 실행");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);
        HashMap<String,Object> input = new HashMap<>();
        Log.d(thisName,"detectResult.getVersion()"+detectResult.getVersion());
        Log.d(thisName,"detectResult.getCountry()"+detectResult.getCountry());
        Log.d(thisName,"detectResult.getIndustry()"+detectResult.getIndustry());
        Log.d(thisName,"detectResult.getCustomer()"+detectResult.getCustomer());
        Log.d(thisName,"detectResult.getMainCategory()"+detectResult.getMainCategory());
        Log.d(thisName,"detectResult.getSubCategory()"+detectResult.getSubCategory());
        Log.d(thisName,"detectResult.getProduct()"+detectResult.getProduct());
        Log.d(thisName,"detectResult.getSeq()"+detectResult.getSeq());
        Log.d(thisName,"detectResult.getIsVariable()"+detectResult.getIsVariable());
        Log.d(thisName,"detectResult.getIsAdmin()"+detectResult.getIsAdmin());
        Log.d(thisName,"detectResult.getIsDigital()"+detectResult.getIsDigital());

        input.put("versionKey",detectResult.getVersion());
        input.put("countryKey",detectResult.getCountry());
        input.put("industryKey",detectResult.getIndustry());
        input.put("teamKey",detectResult.getCustomer());
        input.put("mainCategoryKey",detectResult.getMainCategory());
        input.put("subCategoryKey",detectResult.getSubCategory());
        input.put("projectKey",detectResult.getProduct());
        input.put("productKey",detectResult.getSeq());
        input.put("isVariable",false);
        input.put("isAdminOnly",false);
        input.put("isDigital",false);
        input.put("deviceId",getUuid());
        input.put("deviceInfo","");


        retrofitAPI.postData(input).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()){
                    Post data = response.body();
                    Log.d(thisName,"onResponse() 실행");
                    Log.d(thisName, "response.body() : "+String.valueOf(response.body()));
                    Log.d(thisName, "data.getMessage() : "+data.getMessage());

                    Log.d(thisName,"getTitle() : "+data.getData().getTitle());
                    Log.d(thisName,"getDescription() : "+data.getData().getDescription());
                    Log.d(thisName,"getSourceImage() : "+data.getData().getSourceImage());
                    Log.d(thisName,"getUrlCustom() : "+data.getData().getUrlCustom());

                    onPause();
                    playSoundAndVibrate();

                    //이부분 메소드 처리
                    goSuccessScan();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                t.getCause();
                Log.d(thisName,"onFailure 실행");
            }
        });

    }

    private void goSuccessScan(){
        successFragment = new ScanSuccessFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.scan_child_content,successFragment).commit();
    }

    private void goAlertTime(){
        alertTimeFragment = new AlertTimeFragment(this);
        getChildFragmentManager().beginTransaction().add(R.id.scan_child_content,alertTimeFragment).commitAllowingStateLoss();
    }

    //-> go to Model
    public String getUuid() {
        SharedPreferences mPref = getActivity().getSharedPreferences("KEY_PREF", getActivity().MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }

    //-> go to presenter
    public void playSoundAndVibrate(){
        Log.d(thisName,"playSound() 실행");
        soundPool = new SoundPool.Builder().build();
        soundPool.load(getContext(),R.raw.beep,1);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                AudioManager mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
                float currentVolumeIndex = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolumeIndex = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = currentVolumeIndex / maxVolumeIndex;
                Log.d(thisName,"volume : "+String.valueOf(volume));
                soundManage = soundPool.play(sampleId,volume,volume,1,0,1.0f);
            }
        });

        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {   // -> version 26이상
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            //시간, 세기
        } else {
            vibrator.vibrate(1000);
        }
    }




}


