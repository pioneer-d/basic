package com.snaptag.labcode_china.beidou;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class Location_Manager {

    private static String thisName = "Location_Manager";

    //<-------------------------------------------------------------------------------->
    //////////
    // 상수 //
    //////////
    /**
     * 디바이스의 안드로이드 버전에 따라 사용 할 API 자동 이용
     */
    public static final int API_AUTO = 0;
    /**
     * {@link InnerLocationKitkat}을 이용한 API 이용
     */
    public static final int API_KITKAT = 1;
    /**
     * {@link InnerLocationNougat}을 이용한 API 이용
     */
    public static final int API_NOUGAT = 2;

    //<-------------------------------------------------------------------------------->
    ////////////
    // 클래스 //
    ////////////
    /**
     * 안드로이드 버전 4.4 ~ 6.0까지를 타겟팅한 LOCATION API 정의 클래스
     */
    private InnerLocationKitkat mGpsKitkat;
    /**
     * 안드로이드 버전 7.0 이후 나온 LOCATION API 정의 클래스
     */
    private InnerLocationNougat mGpsNougat;

    //<-------------------------------------------------------------------------------->
    //////////
    // 변수 //
    //////////
    private Context mRootContext;
    private int mUsingApi;
    private boolean mIsUsingKitkat;

    //<-------------------------------------------------------------------------------->
    /**
     * 생성자.
     * @param context {@link Context}
     */
    public Location_Manager(Context context){
        this(context, API_AUTO);
    }

    //<-------------------------------------------------------------------------------->
    /**
     * 생성자.
     * @param context {@link Context}
     */
    public Location_Manager(Context context, int usingApi) {
        this.mRootContext = context;
        init(usingApi);
    }

    //<-------------------------------------------------------------------------------->
    ////////////////////
    // Private Method //
    ////////////////////
    /**
     * 클래스 초기화.
     * @param usingApi 사용 할 API
     *                 {@link #API_AUTO},
     *                 {@link #API_KITKAT},
     *                 {@link #API_NOUGAT}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void init(int usingApi){

        this.mUsingApi = usingApi;

        if(mGpsKitkat != null){
            mGpsKitkat.stop();
            mGpsKitkat = null;
        }

        if(mGpsNougat != null){
            mGpsNougat.stop();
            mGpsNougat = null;
        }

        if(usingApi == API_AUTO){

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {    //version 24보다 낮은 경우
                mGpsKitkat = new InnerLocationKitkat(this.mRootContext);
                this.mIsUsingKitkat = true;
            } else {
                mGpsNougat = new InnerLocationNougat(this.mRootContext);
                this.mIsUsingKitkat = false;
            }

        }else if(usingApi == API_KITKAT){

            mGpsKitkat = new InnerLocationKitkat(this.mRootContext);
            this.mIsUsingKitkat = true;

        }else if(usingApi == API_NOUGAT){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mGpsNougat = new InnerLocationNougat(this.mRootContext);
                this.mIsUsingKitkat = false;
            }else{
                Log.w(thisName, "Can not using API_NOUGAT. Cause device is not supported api. So using API_KITKAT.");

                this.init(API_KITKAT);

            }

        }else{
            Log.w(thisName, "Can not using unknown api(" + String.valueOf(usingApi) + "). Cause " + getClass().getSimpleName() + " is not supported api. So using API_AUTO.");

            this.init(API_AUTO);

        }

    }


    //<-------------------------------------------------------------------------------->
    /**
     * 시작.
     */
    public void start() {
        if(this.mIsUsingKitkat){
            this.mGpsKitkat.start();
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                this.mGpsNougat.start();
            }
        }
    }

    /**
     * 안드로이드 버전 4.4 ~ 6.0까지를 타겟팅한 Location API 정의 클래스
     */
    private class InnerLocationKitkat implements GpsStatus.NmeaListener, LocationListener, GpsStatus.Listener {

        /**
         * {@link Context}
         */
        private Context mContext;

        /**
         * GPS를 사용하기 위한 클래스
         */
        private LocationManager mLocationManager;
        /**
         * 위치 데이터 전달 리스너
         */
        private ArrayList<ILocationListener> mLocationListenerList;
        /**
         * 위성 데이터 전달 리스너
         */
        private ArrayList<ISatelliteListener> mSatelliteListenerList;
        /**
         * NMEA 데이터 전달 리스너
         */
        private ArrayList<INmeaListener> mNmeaListenerList;

        private boolean mIsUseLog;
        private boolean mIsGpsIng;

        /**
         * 생성자.0
         * @param context {@link Context}
         */
        public InnerLocationKitkat(Context context) {

            this.mContext = context;

            initValue();

        }

        /**
         * 초기 값 설정.
         */
        private void initValue() {

            this.mLocationListenerList = new ArrayList<ILocationListener>();
            this.mSatelliteListenerList = new ArrayList<ISatelliteListener>();
            this.mNmeaListenerList = new ArrayList<INmeaListener>();

            this.mIsUseLog = false;
            this.mIsGpsIng = false;

        }


        /**
         * GPS 시작.
         */
        public void start() {

            if (this.mIsGpsIng) {
                Log.e(thisName, "Can not start gps. Cause gps already started.");
                return;
            }

            if (this.mContext == null) {
                Log.e(thisName, "Can not start gps. Cause context is null.");
                return;
            }

            if (!Location_Manager.isLocationSettingOn(this.mContext)) {
                Log.e(thisName, "Can not start gps. Cause gps setting is off.");
                return;
            }

            if (this.mLocationManager == null) {
                this.mLocationManager = (LocationManager) this.mContext.getSystemService(Context.LOCATION_SERVICE);
            }

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                if (this.mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        this.mContext.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Log.e(thisName, "Can not start gps. Cause permission is denied.");
                    return;
                }

            }

            this.mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, InnerLocationKitkat.this);
            this.mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, InnerLocationKitkat.this);

            if (this.mIsUseLog) {
                Log.i(thisName, "START GPS");
            }

            this.mLocationManager.addNmeaListener(this);

            //This method was deprecated in API level 24. -> registerGnssStatusCallback 이거 써야함!
            this.mLocationManager.addGpsStatusListener(this);

            this.mIsGpsIng = true;

        }

        /**
         * GPS 중지.
         */
        public void stop() {

            if (!this.mIsGpsIng) {
                Log.e(thisName, "Can not stop gps. Cause gps already stopped.");
                return;
            }

            if (this.mLocationManager == null) {
                Log.e(thisName, "Can not stop gps. Cause location manager is null.");
                return;
            }

            this.mLocationManager.removeUpdates(this);
            this.mLocationManager.removeNmeaListener(this);
            this.mLocationManager.removeGpsStatusListener(this);

            this.mIsGpsIng = false;

            if (this.mIsUseLog) {
                Log.i(thisName, "STOP GPS");
            }

        }



        /**
         * {@link ILocationListener} 추가.
         * @param listener {@link ILocationListener}
         */
        public void addLocationListener(ILocationListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + ILocationListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mLocationListenerList.add(listener);

        }

        /**
         * {@link ISatelliteListener} 추가.
         * @param listener {@link ISatelliteListener}
         */
        public void addSatelliteListener(ISatelliteListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + ISatelliteListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mSatelliteListenerList.add(listener);

        }

        /**
         * {@link INmeaListener} 추가.
         * @param listener {@link INmeaListener}
         */
        public void addNmeaListener(INmeaListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + INmeaListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mNmeaListenerList.add(listener);

        }


        ////////////////////////////
        // GpsStatus.NmeaListener //
        ////////////////////////////

        /**
         * 참고 URL
         * https://en.wikipedia.org/wiki/NMEA_0183
         * http://www.nmea.org/
         * http://www.trimble.com/oem_receiverhelp/v4.44/en/NMEA-0183messages_MessageOverview.html
         * http://www.catb.org/gpsd/NMEA.html#_sources_and_applicable_standards
         * <p>
         * GPS(Global Positioning System) NMEA : 지구 항법 위성 시스템의 한 구성 요소
         */
        @Override
        public void onNmeaReceived(long timestamp, String nmea) {

            String trimNmea = nmea.trim(); // NMEA 문장 뒤에 붙는 <CR><LF>를 없애기 위해 trim()

            if (this.mIsUseLog) {
                Log.i(thisName, "NMEA RECEIVE : " + "[" + String.valueOf(timestamp) + "] " + trimNmea);
            }

            if (this.mNmeaListenerList != null && this.mNmeaListenerList.size() > 0) {

                for (INmeaListener listener : this.mNmeaListenerList) {
                    listener.onNmea(trimNmea);
                }

            }

        }

        //////////////////////
        // LocationListener //
        //////////////////////
        @Override
        public void onLocationChanged(Location location) {

            if (this.mIsUseLog) {
                Log.i(thisName, "LOCATION CHANGED : " + "[" + location.getProvider() + "] " + location.toString());
            }

            if (this.mLocationListenerList != null && this.mLocationListenerList.size() > 0) {

                int provider = ILocationListener.PROVIDER_UNKNOWN;
                if(LocationManager.GPS_PROVIDER.equalsIgnoreCase(location.getProvider())){
                    provider = ILocationListener.PROVIDER_GPS;
                }else if(LocationManager.NETWORK_PROVIDER.equalsIgnoreCase(location.getProvider())){
                    provider = ILocationListener.PROVIDER_NETWORK;
                }

                for (ILocationListener listener : this.mLocationListenerList) {
                    listener.onLocation(provider, location);
                }

            }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

            String state = "";
            switch (status) {
                case LocationProvider.AVAILABLE: // GPS 사용 가능
                    state = "AVAILABLE";
                    break;
                case LocationProvider.OUT_OF_SERVICE: // GPS 사용 불가능
                    state = "OUT OF SERVICE";
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE: // GPS 일시적 사용 불가능
                    state = "TEMPORARILY UNAVAILABLE";
                    break;
            }

            if (this.mIsUseLog) {
                Log.i(thisName, "'" + provider + "' PROVIDER STATE CHANGED : " + state);
            }

        }

        @Override
        public void onProviderEnabled(String provider) {

            if (this.mIsUseLog) {
                Log.i(thisName, provider + " PROVIDER ENABLED");
            }

        }

        @Override
        public void onProviderDisabled(String provider) {

            if (this.mIsUseLog) {
                Log.i(thisName, provider + " PROVIDER DISABLED");
            }

        }

        ////////////////////////
        // GpsStatus.Listener //
        ////////////////////////
        @Override
        public void onGpsStatusChanged(int event) {

            // FIXME 리스너에서 오류 처리
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                if (this.mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        this.mContext.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

            }

            GpsStatus status = this.mLocationManager.getGpsStatus(null);

            switch (event) {
                case GpsStatus.GPS_EVENT_STARTED: // gps를 잡으려고 시도를 시작하는 때 발생하는 이벤트, requestLocationUpdates호출시 발생

                    if(this.mIsUseLog){
                        Log.i(thisName, "GPS STATUS CHANGED : GPS EVENT STARTED");
                    }

                    break;
                case GpsStatus.GPS_EVENT_STOPPED: // gps를 못 잡은 상황중에서도 프로그램을 종료하면 이 이벤트가 발생, GPS를 못잡고 있을 때 상태바에서 GPS 기능을 끌 때도 발생, removeUpdates 호출시 발생

                    if(this.mIsUseLog){
                        Log.i(thisName, "GPS STATUS CHANGED : GPS EVENT STOPPED");
                    }

                    break;
                case GpsStatus.GPS_EVENT_FIRST_FIX: // 처음으로 실제로 gps data를 받았을 때 실행

                    if(this.mIsUseLog){
                        Log.i(thisName, "GPS STATUS CHANGED : GPS FIRST FIX(" + String.valueOf(status.getTimeToFirstFix()) + ")");
                    }

                    break;
                case GpsStatus.GPS_EVENT_SATELLITE_STATUS: // First Fix 이전에도 이후에도 지속적으로 나타남, gps가 잡혔든 안잡혔든 1초마다 올라옴

                    ArrayList<Satellite> arrayGnss = new ArrayList<Satellite>();
                    int findSat = status.getMaxSatellites();

                    Iterable<GpsSatellite> a = status.getSatellites();
                    for (GpsSatellite sat : a) {

                        float azimuth = sat.getAzimuth();
                        float elevation = sat.getElevation();

                        int prn = sat.getPrn();
                        float snr = sat.getSnr();

                        boolean almanac = sat.hasAlmanac(); // GPS 정확도를 높이기 위한 날씨, 조수, 음력주기등의 DB
                        boolean ephemeris = sat.hasEphemeris();
                        boolean fix = sat.usedInFix();

                        Satellite gnss = new Satellite();
                        gnss.setAzimuth(azimuth);
                        gnss.setElevation(elevation);
                        gnss.setHasAlmanac(almanac);
                        gnss.setHasEphemeris(ephemeris);
                        gnss.setUsedInFix(fix);
                        gnss.setPrn(prn);
                        gnss.setSnr(snr);

                        arrayGnss.add(gnss);

                        if (this.mIsUseLog) {
                            Log.i(thisName, "SATELLITE STATUS CHANGED : [" + String.valueOf(findSat) + "]" + gnss.toString());
                        }

                    }

                    if (this.mSatelliteListenerList != null && this.mSatelliteListenerList.size() > 0) {

                        for (ISatelliteListener listener : this.mSatelliteListenerList) {
                            listener.onSatellite(findSat, arrayGnss);
                        }

                    }

                    break;
            }

        }

    }

    /**
     * 안드로이드 버전 7.0 이후 나온 Location API를 정의한 클래스
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private class InnerLocationNougat extends GnssStatus.Callback implements OnNmeaMessageListener, LocationListener {

        /**
         * {@link Context}
         */
        private Context mContext;

        /**
         * GPS를 사용하기 위한 클래스
         */
        private LocationManager mLocationManager;
        /**
         * 위치 데이터 전달 리스너
         */
        private ArrayList<ILocationListener> mLocationListenerList;
        /**
         * 위성 데이터 전달 리스너
         */
        private ArrayList<ISatelliteListener> mSatelliteListenerList;
        /**
         * NMEA 데이터 전달 리스너
         */
        private ArrayList<INmeaListener> mNmeaListenerList;

        private boolean mIsUseLog;
        private boolean mIsGpsIng;

        public InnerLocationNougat(Context context) {

            this.mContext = context;

            initValue();

        }

        /**
         * 초기 값 설정.
         */
        private void initValue() {

            this.mLocationListenerList = new ArrayList<ILocationListener>();
            this.mSatelliteListenerList = new ArrayList<ISatelliteListener>();
            this.mNmeaListenerList = new ArrayList<INmeaListener>();

            this.mIsUseLog = false;
            this.mIsGpsIng = false;

        }

        /**
         * 로그 사용 여부 설정.
         * @param isUseLog true : 로그 사용, false : 로그 사용 안함
         */
        public void setUseLog(boolean isUseLog) {
            this.mIsUseLog = isUseLog;
        }

        /**
         * GPS 시작.
         */
        public void start() {

            if (this.mIsGpsIng) {
                Log.e(thisName, "Can not start gps. Cause gps already started.");
                return;
            }

            if (this.mContext == null) {
                Log.e(thisName, "Can not start gps. Cause context is null.");
                return;
            }

            if (!isLocationSettingOn(this.mContext)) {
                Log.e(thisName, "Can not start gps. Cause gps setting is off.");
                return;
            }

            if (this.mLocationManager == null) {
                this.mLocationManager = (LocationManager) this.mContext.getSystemService(Context.LOCATION_SERVICE);
            }

            if (this.mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    this.mContext.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.e(thisName, "Can not start gps. Cause permission is denied.");
                return;
            }

            this.mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, InnerLocationNougat.this);
            this.mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, InnerLocationNougat.this);

            if (this.mIsUseLog) {
                Log.i(thisName, "START GPS");
            }

            this.mLocationManager.addNmeaListener(this);
            this.mLocationManager.registerGnssStatusCallback(this);

            this.mIsGpsIng = true;

        }

        /**
         * GPS 중지.
         */
        public void stop() {

            if(!this.mIsGpsIng){
                Log.e(thisName, "Can not stop gps. Cause gps already stopped.");
                return;
            }

            if (this.mLocationManager == null) {
                Log.e(thisName, "Can not stop gps. Cause location manager is null.");
                return;
            }

            this.mLocationManager.removeUpdates(this);
            this.mLocationManager.removeNmeaListener(this);
            this.mLocationManager.unregisterGnssStatusCallback(this);

            this.mIsGpsIng = false;

            if(this.mIsUseLog) {
                Log.i(thisName, "STOP GPS");
            }

        }

        /**
         * GPS 실행 중 여부 반환.
         * @return true : GPS 실행 중, false : GPS 실행 중 아님
         */
        public boolean isRunning(){
            return this.mIsGpsIng;
        }

        /**
         * {@link ILocationListener} 추가.
         * @param listener {@link ILocationListener}
         */
        public void addLocationListener(ILocationListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + ILocationListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mLocationListenerList.add(listener);

        }

        /**
         * {@link ISatelliteListener} 추가.
         * @param listener {@link ISatelliteListener}
         */
        public void addSatelliteListener(ISatelliteListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + ISatelliteListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mSatelliteListenerList.add(listener);

        }

        /**
         * {@link INmeaListener} 추가.
         * @param listener {@link INmeaListener}
         */
        public void addNmeaListener(INmeaListener listener){

            if(listener == null){
                Log.e(thisName, "Can not add " + INmeaListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mNmeaListenerList.add(listener);

        }

        /**
         * {@link ILocationListener} 삭제.
         * @param listener {@link ILocationListener}
         */
        public void removeLocationListener(ILocationListener listener) {

            if (listener == null) {
                Log.e(thisName, "Can not remove " + ILocationListener.class.getSimpleName() + ". Cause listener parameter is null.");
                return;
            }

            this.mLocationListenerList.remove(listener);

        }


        ///////////////////////////
        // OnNmeaMessageListener //
        ///////////////////////////
        /**
         * 참고 URL
         * https://en.wikipedia.org/wiki/NMEA_0183
         * http://www.nmea.org/
         * http://www.trimble.com/oem_receiverhelp/v4.44/en/NMEA-0183messages_MessageOverview.html
         * http://www.catb.org/gpsd/NMEA.html#_sources_and_applicable_standards
         *
         * GNSS(Global Navigation Satellite System) : 모든 글로벌 위성 위치 확인 시스템을 포괄하는 포괄적인 용어
         */
        @Override
        public void onNmeaMessage(String nmea, long timestamp) {

            if (this.mIsUseLog) {
                Log.i(thisName, "NMEA RECEIVE : " + "[" + String.valueOf(timestamp) + "] " + nmea);
            }

            if (this.mNmeaListenerList != null && this.mNmeaListenerList.size() > 0) {

                for (INmeaListener listener : this.mNmeaListenerList) {
                    listener.onNmea(nmea);
                }

            }

        }

        //////////////////////
        // LocationListener //
        //////////////////////
        @Override
        public void onLocationChanged(Location location) {

            if (this.mIsUseLog) {
                Log.i(thisName, "LOCATION CHANGED : " + "[" + location.getProvider() + "] " + location.toString());
            }

            if (this.mLocationListenerList != null && this.mLocationListenerList.size() > 0) {

                int provider = ILocationListener.PROVIDER_UNKNOWN;
                if(LocationManager.GPS_PROVIDER.equalsIgnoreCase(location.getProvider())){
                    provider = ILocationListener.PROVIDER_GPS;
                }else if(LocationManager.NETWORK_PROVIDER.equalsIgnoreCase(location.getProvider())){
                    provider = ILocationListener.PROVIDER_NETWORK;
                }

                for (ILocationListener listener : this.mLocationListenerList) {
                    listener.onLocation(provider, location);
                }

            }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

            String state = "";
            switch (status) {
                case LocationProvider.AVAILABLE: // GPS 사용 가능
                    state = "AVAILABLE";
                    break;
                case LocationProvider.OUT_OF_SERVICE: // GPS 사용 불가능
                    state = "OUT OF SERVICE";
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE: // GPS 일시적 사용 불가능
                    state = "TEMPORARILY UNAVAILABLE";
                    break;
            }

            if (this.mIsUseLog) {
                Log.i(thisName, "'" + provider + "' PROVIDER STATE CHANGED : " + state);
            }

        }

        @Override
        public void onProviderEnabled(String provider) {

            if (this.mIsUseLog) {
                Log.i(thisName, provider + " PROVIDER ENABLED");
            }

        }

        @Override
        public void onProviderDisabled(String provider) {

            if (this.mIsUseLog) {
                Log.i(thisName, provider + " PROVIDER DISABLED");
            }

        }

        /////////////////////////
        // GnssStatus.Callback //
        /////////////////////////
        @Override
        public void onStarted() {
            super.onStarted();

            if(this.mIsUseLog){
                Log.i(thisName, "GPS STATUS CHANGED : GPS STARTED");
            }

        }

        @Override
        public void onStopped() {
            super.onStopped();

            if(this.mIsUseLog){
                Log.i(thisName, "GPS STATUS CHANGED : GPS STOPPED");
            }

        }

        @Override
        public void onFirstFix(int ttffMillis) {
            super.onFirstFix(ttffMillis);

            if(this.mIsUseLog){
                Log.i(thisName, "GPS STATUS CHANGED : GPS FIRST FIX(" + String.valueOf(ttffMillis) + ")");
            }

        }

        @Override
        public void onSatelliteStatusChanged(GnssStatus status) {
            super.onSatelliteStatusChanged(status);

            ArrayList<Satellite> arrayGnss = new ArrayList<Satellite>();
            int findSat = status.getSatelliteCount();

            for (int i = 0; i < findSat; i++) {

                float azimuth = status.getAzimuthDegrees(i);
                float elevation = status.getElevationDegrees(i); // 위성 고도

                int constellationType = status.getConstellationType(i); // 위성 타입
                float cn0DbHz = status.getCn0DbHz(i); // 신호세기(?) 단위 : db-Hz
                int svid = status.getSvid(i); // 식별번호

                boolean almanac = status.hasAlmanacData(i); // GPS 정확도를 높이기 위한 날씨, 조수, 음력주기등의 DB
                boolean ephemeris = status.hasEphemerisData(i);
                boolean fix = status.usedInFix(i);

                Satellite gnss = new Satellite();
                gnss.setAzimuth(azimuth);
                gnss.setElevation(elevation);
                gnss.setHasAlmanac(almanac);
                gnss.setHasEphemeris(ephemeris);
                gnss.setUsedInFix(fix);
                gnss.setConstellationType(constellationType);
                gnss.setCn0Dbhz(cn0DbHz);
                gnss.setSvid(svid);

                arrayGnss.add(gnss);

                String type = "UNKNOWN";
                switch (constellationType) {
                    case GnssStatus.CONSTELLATION_GPS:
                        type = "GPS";
                        break;
                    case GnssStatus.CONSTELLATION_SBAS:
                        type = "SBAS";
                        break;
                    case GnssStatus.CONSTELLATION_GLONASS:
                        type = "GLONASS";
                        break;
                    case GnssStatus.CONSTELLATION_QZSS:
                        type = "QZSS";
                        break;
                    case GnssStatus.CONSTELLATION_BEIDOU:
                        type = "BEIDOU";
                        break;
                    case GnssStatus.CONSTELLATION_GALILEO:
                        type = "GALILEO";
                        break;
                    case GnssStatus.CONSTELLATION_UNKNOWN:
                        type = "UNKNOWN";
                        break;
                }

                if (this.mIsUseLog) {
                    Log.i(thisName, "SATELLITE STATUS CHANGED : [" + String.valueOf(findSat) + "]" + gnss.toString());
                }

            }

            if (this.mSatelliteListenerList != null && this.mSatelliteListenerList.size() > 0) {

                for (ISatelliteListener listener : this.mSatelliteListenerList) {
                    listener.onSatellite(findSat, arrayGnss);
                }

            }

        }

    }

    /**
     * GPS 설정이 켜져있는지 여부 반환.
     * GPS가 켜져있어도 위치 인식방식 옵션이 배터리 절전일 경우 false 반환.
     * @return true : 설정 켜져있음, false : 설정 꺼져있음
     */
    public static boolean isLocationSettingOn(Context context) {

        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER) &&
                !manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            return false;
        }

        return true;

    }

    /**
     * GPS를 사용하기 위한 권한 획득 여부 반환.
     * @return true : 권한 획득 됨, false : 권한 획득 안 됨
     */
    public static boolean isGrantedPermission(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (context.checkSelfPermission(ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    context.checkSelfPermission(ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }

            return true;

        }

        return true;

    }

    /**
     * GPS를 사용하기 위한 권한 획득 요청.
     * 안드로이드 버전 6.0(API 23) 이상부터 메소드 사용가능.
     * 파라미터로 넘긴 콜백을 받는 액티비티에는
     * {@link Activity#onRequestPermissionsResult(int, String[], int[])} 메소드를 정의하여
     * 권환 획득 요청 결과에 따른 처리를 진행하면 됨.
     * @param callBackActivity 권한 획득 요청 콜백을 받을 액티비티
     * @param requestCode 권한 획득 요청 코드
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void requestPermission(Activity callBackActivity, int requestCode) {
        callBackActivity.requestPermissions(new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, requestCode);
    }

    /**
     * 위치 정보 전달 인터페이스.
     */
    public interface ILocationListener{

        public static final int PROVIDER_UNKNOWN = -1;
        public static final int PROVIDER_GPS = 1;
        public static final int PROVIDER_NETWORK = 2;

        /**
         * 위치가 변경 될 경우 호출.
         * @param provider 위치 제공자
         *                 {@link #PROVIDER_GPS},
         *                 {@link #PROVIDER_NETWORK}
         * @param location
         */
        public void onLocation(int provider, Location location);

    }

    /**
     * 위성 정보 전달 인터페이스.
     */
    public interface ISatelliteListener{

        /**
         * 위성 정보를 수신한 경우 호출.
         *
         * 안드로이드 버전 4.4 ~ 6.0까지의 디바이스 사용시
         * {@link Satellite#getConstellationType()},
         * {@link Satellite#getCn0Dbhz()},
         * {@link Satellite#getSvid()}는 사용되지 않음.
         *
         * 안드로이드 버전 7.0 이후의 디바이스 사용시
         * {@link Satellite#getPrn()},
         * {@link Satellite#getSnr()}은 사용되지 않음.
         *
         * @param findSatellite 찾은 총 위성의 수
         * @param arrayGnss 위성 정보를 담은 배열
         *                  {@link Satellite}
         */
        public void onSatellite(int findSatellite, ArrayList<Satellite> arrayGnss);

    }

    /**
     * RAW 정보 전달 인터페이스.
     */
    public interface INmeaListener{

        /**
         * NMEA 문장을 수신한 경우 호출.
         * @param nmea NMEA 문장
         */
        public void onNmea(String nmea);

    }

    /**
     * 위성 정보를 담을 객체.
     */
    public class Satellite {

        private float mAzimuth;
        private float mElevation;
        private boolean mHasAlmanac;
        private boolean mHasEphemeris;
        private boolean mUsedInFix;

        // GpsStatus.Listener.onGpsStatusChanged(int event)에서 나오는 정보를 담기 위한 변수
        // 안드로이드 버전 킷캣 이상, 누가 미만에서만 사용
        private int mPrn;
        private float mSnr;

        // GnssStatus.Callback.onSatelliteStatusChanged(Gnss status)에서 나오는 정보를 담기 위한 변수
        // 안드로이드 버전 누가 이상에서만 사용
        private int mConstellationType;
        private float mCn0Dbhz;
        private int mSvid;

        public Satellite(){

            this.mAzimuth = 0.0f;
            this.mElevation = 0.0f;
            this.mHasAlmanac = false;
            this.mHasEphemeris = false;
            this.mUsedInFix = false;

            this.mPrn = 0;
            this.mSnr = 0.0f;

            this.mConstellationType = 0;
            this.mCn0Dbhz = 0.0f;
            this.mSvid = 0;

        }

        public float getAzimuth() {
            return mAzimuth;
        }

        public void setAzimuth(float azimuth) {
            this.mAzimuth = azimuth;
        }

        public float getElevation() {
            return mElevation;
        }

        public void setElevation(float elevation) {
            this.mElevation = elevation;
        }

        public boolean hasAlmanac() {
            return mHasAlmanac;
        }

        public void setHasAlmanac(boolean hasAlmanac) {
            this.mHasAlmanac = hasAlmanac;
        }

        public boolean hasEphemeris() {
            return mHasEphemeris;
        }

        public void setHasEphemeris(boolean hasEphemeris) {
            this.mHasEphemeris = hasEphemeris;
        }

        public boolean isUsedInFix() {
            return mUsedInFix;
        }

        public void setUsedInFix(boolean usedInFix) {
            this.mUsedInFix = usedInFix;
        }

        public int getPrn() {
            return mPrn;
        }

        public void setPrn(int prn) {
            this.mPrn = prn;
        }

        public float getSnr() {
            return mSnr;
        }

        public void setSnr(float snr) {
            this.mSnr = snr;
        }

        public int getConstellationType() {
            return mConstellationType;
        }

        /**
         * 위성 타입 반환.
         * @param constellationType {@link GnssStatus#CONSTELLATION_GPS},
         *                          {@link GnssStatus#CONSTELLATION_SBAS},
         *                          {@link GnssStatus#CONSTELLATION_GLONASS},
         *                          {@link GnssStatus#CONSTELLATION_QZSS},
         *                          {@link GnssStatus#CONSTELLATION_BEIDOU},
         *                          {@link GnssStatus#CONSTELLATION_GALILEO},
         *                          {@link GnssStatus#CONSTELLATION_UNKNOWN}
         */
        public void setConstellationType(int constellationType) {
            this.mConstellationType = constellationType;
        }

        public float getCn0Dbhz() {
            return mCn0Dbhz;
        }

        public void setCn0Dbhz(float cn0Dbhz) {
            this.mCn0Dbhz = cn0Dbhz;
        }

        public int getSvid() {
            return mSvid;
        }

        public void setSvid(int svid) {
            this.mSvid = svid;
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append("Gnss satellite[");
            sb.append("azimuth=" + String.format("%.2f", mAzimuth));
            sb.append(", elevation=" + String.format("%.2f", mElevation));
            sb.append(", hasAlmanac=" + String.valueOf(mHasAlmanac));
            sb.append(", hasEphemeric=" + String.valueOf(mHasEphemeris));
            sb.append(", usedFix=" + String.valueOf(mUsedInFix));
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
                sb.append(", prn=" + String.valueOf(mPrn));
                sb.append(", snr=" + String.valueOf(mSnr));
            }else{
                String type = "UNKNOWN";
                switch (mConstellationType) {
                    case GnssStatus.CONSTELLATION_GPS:
                        type = "GPS";
                        break;
                    case GnssStatus.CONSTELLATION_SBAS:
                        type = "SBAS";
                        break;
                    case GnssStatus.CONSTELLATION_GLONASS:
                        type = "GLONASS";
                        break;
                    case GnssStatus.CONSTELLATION_QZSS:
                        type = "QZSS";
                        break;
                    case GnssStatus.CONSTELLATION_BEIDOU:
                        type = "BEIDOU";
                        break;
                    case GnssStatus.CONSTELLATION_GALILEO:
                        type = "GALILEO";
                        break;
                }
                sb.append(", constellationType=" + String.valueOf(type));
                sb.append(", svid=" + String.valueOf(mSvid));
                sb.append(", cn0DbHz=" + String.valueOf(mCn0Dbhz));
            }
            sb.append("]");

            return sb.toString();

        }

    }


}
