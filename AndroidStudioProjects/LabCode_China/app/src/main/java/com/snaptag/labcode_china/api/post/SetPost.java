package com.snaptag.labcode_china.api.post;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.UUID;

public class SetPost {

    Activity activity;
    private String versionKey;
    private String countryKey;
    private String industryKey;
    private String teamKey;
    private String mainCategoryKey;
    private String ubCategoryKey;
    private String projectKey;
    private String productKey;
    private boolean isVariable;
    private boolean isAdminOnly;
    private boolean isDigital;
    private String deviceId = getUuid();
    private String deviceInfo;


    public SetPost(Activity activity){
        this.activity = activity;
    }


    private void initUuid() {
        SharedPreferences mPref = activity.getSharedPreferences("KEY_PREF", activity.MODE_PRIVATE);
        String uuid = mPref.getString("KEY_UUID", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();

            mPref.edit().putString("KEY_UUID", uuid + "5").apply();
        }
    }

    public String getUuid() {
        SharedPreferences mPref = activity.getSharedPreferences("KEY_PREF", activity.MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getVersionKey() {
        return versionKey;
    }

    public void setVersionKey(String versionKey) {
        this.versionKey = versionKey;
    }

    public String getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
    }

    public String getIndustryKey() {
        return industryKey;
    }

    public void setIndustryKey(String industryKey) {
        this.industryKey = industryKey;
    }

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getMainCategoryKey() {
        return mainCategoryKey;
    }

    public void setMainCategoryKey(String mainCategoryKey) {
        this.mainCategoryKey = mainCategoryKey;
    }

    public String getUbCategoryKey() {
        return ubCategoryKey;
    }

    public void setUbCategoryKey(String ubCategoryKey) {
        this.ubCategoryKey = ubCategoryKey;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public boolean isVariable() {
        return isVariable;
    }

    public void setVariable(boolean variable) {
        isVariable = variable;
    }

    public boolean isAdminOnly() {
        return isAdminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        isAdminOnly = adminOnly;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

}
