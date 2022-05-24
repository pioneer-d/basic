package com.snaptag.labcode_china.navigation.scan.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.snaptag.cameramodule.STCameraView;
import com.snaptag.cameramodule.model.DetectResult;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.api.post.Post;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.scan.page.AlertTimeFragment;
import com.snaptag.labcode_china.navigation.scan.page.ControlSettingFragment;
import com.snaptag.labcode_china.navigation.scan.page.ScanSuccessActivity;
import com.snaptag.labcode_china.network.GetLocation;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ScanControlFragment extends Fragment implements View.OnClickListener, STCameraView.OnDetectResultListener {

    private static ScanControlFragment instance;

    private ScanControlFragment() {
    }

    private static String thisName = "ScanControlFragment";

    private View view;
    private STCameraView stCameraView = null;
    private ImageButton cameraSetting, flashButton, flash2, zoom, zoomMore, zoom_1_0, zoom_1_5, zoom_2_0;
    private TextView guideText;
    SharedPreferences mPref;

    //Timer 관련
    private Timer timer;
    private TimerTask task;
    int onGoingTime = 0;
    private boolean isCancel = false;

    //sound관련
    SoundPool soundPool;
    private int soundManage;
    private boolean soundDegree;

    //vibrate 관련
    Vibrator vibrator;
    private boolean vibrateDegree;

    //위치 정보 관련
    LocationManager locationManager;

    //로딩
    ProgressDialog dialog;
    Disposable backgroundTask;

    //리뉴얼 Location Data
    String getLocationData;
    double longitude;
    double latitude;

    //API 관련
    private ConstraintLayout zoomBox;
    private MutableLiveData detectResult = new MutableLiveData<DetectResult>();
    static String BASEURL = "https://admin.labcode.kr/";

    //page이동
    private Fragment successFragment;
    private Fragment alertTimeFragment;

    private boolean flashClick = false;
    private boolean zoomClick = false;

    public static ScanControlFragment newInstance() {
        if (instance == null) {
            instance = new ScanControlFragment();
        }
        return instance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Log.d(thisName,"onCreate() 실행");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scan_control, container, false);
        initUuid();
        Log.d(thisName,"getUuid() : "+getUuid());

        stCameraView = (STCameraView) view.findViewById(R.id.st_camera);
        cameraSetting = view.findViewById(R.id.camera_setting);
        flashButton = view.findViewById(R.id.flash);
        flash2 = view.findViewById(R.id.flash2_frame).findViewById(R.id.flash2);
        zoom = view.findViewById(R.id.zoom);
        zoomMore = view.findViewById(R.id.zoom_more_frame).findViewById(R.id.zoom_more);

        zoomBox = view.findViewById(R.id.zoom_box);
        zoom_1_0 = view.findViewById(R.id.zoom_1_0);
        zoom_1_5 = view.findViewById(R.id.zoom_1_5);
        zoom_2_0 = view.findViewById(R.id.zoom_2_0);

        //API 관련
        guideText = view.findViewById(R.id.guideText);

        //위치 정보 관련
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        cameraSetting.setOnClickListener(this);
        flashButton.setOnClickListener(this);
        flash2.setOnClickListener(this);
        zoom.setOnClickListener(this);
        zoomMore.setOnClickListener(this);
        zoom_1_0.setOnClickListener(this);
        zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
        zoom_1_5.setOnClickListener(this);
        zoom_2_0.setOnClickListener(this);

        //임시 로딩창
        dialog = new ProgressDialog(getActivity());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("GPS 얻어오는 중...");

        initCameraModule();
        return view;
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId) {
            case R.id.camera_setting:
                goCameraSetting();
                break;
            case R.id.flash: case R.id.flash2:
                flashClick = (flashClick == true) ? false : true;
                if (flashClick == true) {
                    flashButton.setImageResource(R.drawable.ic_filled_circle);
                    stCameraView.setFlash(true);
                } else {
                    flashButton.setImageResource(R.drawable.ic_blanked_circle);
                    stCameraView.setFlash(false);
                }
                break;
            case R.id.zoom: case R.id.zoom_more:
                zoomClick = (zoomClick == true) ? false : true;
                if (zoomClick == true) {
                    zoom.setImageResource(R.drawable.ic_filled_circle);
                    zoomBox.setVisibility(View.VISIBLE);
                } else {
                    zoom.setImageResource(R.drawable.ic_blanked_circle);
                    zoomBox.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.zoom_1_0:
                zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                stCameraView.setZoom(1.0f);
                break;
            case R.id.zoom_1_5:
                zoom_1_5.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                stCameraView.setZoom(1.5f);
                break;
            case R.id.zoom_2_0:
                zoom_2_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                stCameraView.setZoom(2.0f);
                break;
        }


    }

    private void initCameraModule() {
        stCameraView.setDetectListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(thisName, "onResume() 실행");

        //여기서 먼저 호출하고
        GetLocation locationManager = new GetLocation(getActivity());
        locationManager.callLocation();

        clearFlashZoom();
        settingSoundVibrate();

        getLocationData = getGps();
        setLocation();
        //if (getLocationData == null){
         //   dialog.show();
//            while (getLocationData == null){
//                Log.d(thisName,"null로 인한 getGps() 반복 실행");
//                getLocationData = getGps();
            //코루틴이나 RxJava 활용해야할 듯 함.
//            }
        //} else{

        Log.d(thisName,"getLocationData : "+getLocationData);

        //이게 여기 있으면 gps 못받아와도 카메라가 실행되니까 순서 다시 봐야함.
//        if (stCameraView != null) {
//            stCameraView.setStartZoom(1.0f);
//            stCameraView.setFlash(false);
//            Log.d(thisName, "stDetectStart() 실행직전");
//            stCameraView.stDetectStart();
//            }
        //}

        onGoingTime = 0;
        startTimer();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(thisName, "onPause() 실행");
        stopTimer();
        stCameraView.stDetectStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(thisName, "onDestroy() 실행");
        stopTimer();
    }

    //-> go to presenter
    private void startTimer() {
        Log.d(thisName, "startTimer() 실행");

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                onGoingTime++;
                Log.d(thisName, "onGoingTime : " + String.valueOf(onGoingTime));

                if (onGoingTime % 9 == 0) {
                    guideText.setText(R.string.txt_scan_guide_first);
                } else if (onGoingTime % 9 == 3) {
                    guideText.setText(R.string.txt_scan_guide_second);
                } else if (onGoingTime % 9 == 6) {
                    guideText.setText(R.string.txt_scan_guide_third);
                }
                if (onGoingTime == 30) {
                    stopTimer();
                }

            }
        };
        timer.schedule(task, 0, 1000);
    }

    private void stopTimer() {
        Log.d(thisName, "stopTimer() 실행");
        timer.cancel();
        if (onGoingTime == 30) {
            goAlertTime();
        }
    }

    @Override
    public void getDetectResult(JsonObject jsonObject) {

    }

    @Override
    public void getDetectResult(DetectResult detectResult) {
        //if (it.getResultType() == DetectResult.DETECTSUCCESS) ??
        Log.d(thisName, "getDetectResult() 실행");
        if (detectResult != null) {
            Log.d(thisName, "getDetectResult() 내부 detectResult != null() ");
            Log.d(thisName, "detectResult : " + detectResult);
            this.detectResult.setValue(detectResult);
            Log.d(thisName, String.valueOf(this.detectResult.getValue()));
            goToResult((DetectResult) this.detectResult.getValue());
        }
    }

    //-> goToPresenter or Model
    private void goToResult(DetectResult detectResult) {
        Log.d(thisName, "goToResult() 실행");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);
        HashMap<String, Object> input = new HashMap<>();

        Log.d(thisName,"스캔 성공시 getLocationData : "+getGps());

        input.put("versionKey", detectResult.getVersion());
        input.put("countryKey", detectResult.getCountry());
        input.put("industryKey", detectResult.getIndustry());
        input.put("teamKey", detectResult.getCustomer());
        input.put("mainCategoryKey", detectResult.getMainCategory());
        input.put("subCategoryKey", detectResult.getSubCategory());
        input.put("projectKey", detectResult.getProduct());
        input.put("productKey", detectResult.getSeq());
        input.put("isVariable", false);
        input.put("isAdminOnly", false);
        input.put("isDigital", false);
        input.put("deviceId", getUuid());
        input.put("deviceInfo", "");

        retrofitAPI.postData(input).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    playSoundAndVibrate();

                    Post data = response.body();
                    Log.d(thisName, "onResponse() 실행");
                    Log.d(thisName, "response.body() : " + String.valueOf(response.body()));
                    Log.d(thisName, "data.getMessage() : " + data.getMessage());


//                    Log.d(thisName, "getTitle() : " + data.getData().getTitle());
//                    Log.d(thisName, "getDescription() : " + data.getData().getDescription());
//                    Log.d(thisName, "getSourceImage() : " + data.getData().getSourceImage());
//                    Log.d(thisName, "getUrlCustom() : " + data.getData().getUrlCustom());

                    String checkIndustry = data.getData().getProject().getIndustry().getKey();
                    String url = data.getData().getUrl();
                    Log.d(thisName,"checkIndustry : "+checkIndustry);

                    if (checkIndustry.equals("0")){
                        Log.d(thisName,"checkIndustry == \"0\"인 경우");
                        String image = data.getData().getProject().getBannerImage();
                        String genre = data.getData().getProject().getIndustry().getTitle();
                        if (genre == null){genre = "Test";}
                        String product = data.getData().getProject().getTitle();
                        if (product == null){product = "SnapTag";}
                        String brand = data.getData().getProject().getTeam().getTitle();
                        if (brand == null){brand = "SnapTag";}

                        //여기서 activity로 변환.
                        //goSuccessScan(image,genre,product,brand,url);
                        Intent intent = new Intent(getActivity(), ScanSuccessActivity.class);
                        intent.putExtra("image",image);
                        intent.putExtra("genre",genre);
                        intent.putExtra("product",product);
                        intent.putExtra("brand",brand);
                        intent.putExtra("url",url);
                        startActivity(intent);


                    } else{
                        Log.d(thisName,"checkIndustry == \"0\"이 아닌 경우");
                        goWebBrowser(url);
                    }
                    onPause();


                    //goSuccessScan(); -> industry가 0번일때만 이동.
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                t.getCause();
                Log.d(thisName, "onFailure 실행");
            }
        });
    }

    private void goCameraSetting(){
        ControlSettingFragment controlSettingFragment = new ControlSettingFragment();
        getChildFragmentManager().beginTransaction().add(R.id.scan_child_content, controlSettingFragment).commitAllowingStateLoss();
        onPause();
    }

    private void goAlertTime() {
        alertTimeFragment = new AlertTimeFragment(this);
        getChildFragmentManager().beginTransaction().add(R.id.scan_child_content, alertTimeFragment).commitAllowingStateLoss();
    }

    //-> go to Model
    public String getUuid() {
        mPref = getActivity().getSharedPreferences("KEY_PREF", getActivity().MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }

    //-> go to presenter
    public void playSoundAndVibrate() {
        Log.d(thisName, "playSound() 실행");
        soundPool = new SoundPool.Builder().build();
        soundPool.load(getContext(), R.raw.beep, 1);

        Log.d(thisName,"sound : "+String.valueOf(soundDegree));
        Log.d(thisName,"vibrate : "+String.valueOf(vibrateDegree));

        if (soundDegree) {
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    AudioManager mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
                    float currentVolumeIndex = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                    float maxVolumeIndex = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                    float volume = currentVolumeIndex / maxVolumeIndex;
                    Log.d(thisName, "SoundVolume : " + String.valueOf(volume));
                    soundManage = soundPool.play(sampleId, volume, volume, 1, 0, 1.0f);
                }
            });
        }

        if (vibrateDegree) {
            vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            int vibrateVolume = VibrationEffect.DEFAULT_AMPLITUDE;
            Log.d(thisName, "VibrateVolume : " + String.valueOf(vibrateVolume));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {   // -> version 26이상
                vibrator.vibrate(VibrationEffect.createOneShot(200, vibrateVolume));
                //시간, 세기
            } else {
                vibrator.vibrate(1000);
            }
        }
    }


    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            Log.d(thisName, "onLocationChanged(  ) 실행");
            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
            double accuracy = location.getAccuracy();
            Log.d(thisName,"위치정보 : " + provider + "\n" + "위도 : " + longitude + "\n" + "경도 : " + latitude + "\n" + "고도 : " + altitude + "\n" + "정확도 : " + accuracy);

            //stopLocation();
            dialog.cancel();

            if (stCameraView != null) {
                stCameraView.setStartZoom(1.0f);
                stCameraView.setFlash(false);
                Log.d(thisName, "stDetectStart() 실행직전");
                stCameraView.stDetectStart();
            }
        }
    };


    private void initUuid() {
        Log.d(thisName,"initUuid() 실행");
        mPref = getActivity().getSharedPreferences("KEY_PREF", getActivity().MODE_PRIVATE);
        String uuid = mPref.getString("KEY_UUID", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();

            mPref.edit().putString("KEY_UUID", uuid + "5").apply();
        }
    }


    private void goWebBrowser(String url){
        String confirmUrl = url;
        if (!URLUtil.isValidUrl(confirmUrl)) {
            confirmUrl = "http://snaptag.com.cn";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(confirmUrl));
        getActivity().startActivity(intent);
    }

    public String getGps(){
        mPref = getActivity().getSharedPreferences("LOCATION_PREF", getActivity().MODE_PRIVATE);
        String getLocationData = mPref.getString("LOCATION_PREF", null);
        return getLocationData;
    }

    public void clearFlashZoom(){
        flashClick = false;
        zoomClick = false;
        flashButton.setImageResource(R.drawable.ic_blanked_circle);
        zoomBox.setVisibility(View.INVISIBLE);
        zoom.setImageResource(R.drawable.ic_blanked_circle);
        zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
        zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
        zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
    }

    public void settingSoundVibrate(){
        Log.d(thisName,"settingSoundVibrate() 실행");
        mPref = getActivity().getSharedPreferences("SOUND_PREF", getActivity().MODE_PRIVATE);
        if (mPref.getString("SOUND_PREF", null) == null){
            soundDegree = true;
        }else {
            soundDegree = Boolean.valueOf(mPref.getString("SOUND_PREF", null));
        }
        Log.d(thisName,"soundDegree : "+String.valueOf(soundDegree));

        mPref = getActivity().getSharedPreferences("VIBRATE_PREF", getActivity().MODE_PRIVATE);
        if (mPref.getString("VIBRATE_PREF", null) == null){
            vibrateDegree = true;
        } else {
            vibrateDegree = Boolean.valueOf(mPref.getString("VIBRATE_PREF", null));
        }
        Log.d(thisName,"vibrateDegree : "+String.valueOf(vibrateDegree));
    }

//    public void setLocation(){
//        GetLocation locationManager = new GetLocation(getActivity());
//        locationManager.callLocation();
//    }

    private void setLocation() {
        // task에서 반환할 Hashmap
        Log.d(thisName,"setLocation() 실행");
        HashMap<String, String> map = new HashMap<>();
        dialog.show();
        //onPreExecute(task 시작 전 실행될 코드 여기에 작성)

        backgroundTask = Observable.fromCallable(() -> {
            //doInBackground(task에서 실행할 코드 여기에 작성)
            Log.d(thisName,"getGps 실행()");
            getLocationData = getGps();

            return map;

        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HashMap<String, String>>() {
            @Override
            public void accept(HashMap<String, String> map) {
                //onPostExecute(task 끝난 후 실행될 코드 여기에 작성)
                Log.d(thisName,"getLocationData 받아온 경우");
                Log.d(thisName,"getLocationData : "+getLocationData);
                dialog.cancel();
                if (stCameraView != null) {
                    stCameraView.setStartZoom(1.0f);
                    stCameraView.setFlash(false);
                    Log.d(thisName, "stDetectStart() 실행직전");
                    stCameraView.stDetectStart();
                }

                backgroundTask.dispose();
            }
        });
    }
}


