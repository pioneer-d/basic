package com.snaptag.labcode_china.splash.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.network.NetworkConfirm;
import com.snaptag.labcode_china.splash.model.SplashModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplashPresenter implements SplashContract.Presenter {

    static String thisName = "SplashPresenter";
    NetworkConfirm confirm = NetworkConfirm.getInstance();

    SplashContract.View view;
    SplashModel model;
    Activity activity;

    public SplashPresenter(SplashContract.View view, Activity activity){
        this.view = view;
        model = new SplashModel(this,activity);
        this.activity = activity;
    }

    @Override
    public void splashHandler(int sec, Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkPersonalAccess()){
                    if (confirm.confirmNetwork(context)){
                        view.goCameraAccessRight();
                    } else {
                        view.networkError();
                    }
                } else {
                    alertPersonalAccess();
                }

            }
        }, 1000 * sec);
    }

    public boolean checkPersonalAccess(){
        Log.d(thisName,"모델에서 가져온 값 : "+model.getPersonalAccess());
        return Boolean.parseBoolean(model.getPersonalAccess());
    }

    public void setPersonalAccess(){
        SharedPreferences mPref = activity.getSharedPreferences("PERSONAL_ACCESS_PREF", activity.MODE_PRIVATE);
        mPref.edit().putString("PERSONAL_ACCESS_PREF", "true").apply();
    }

    public void alertPersonalAccess(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle(R.string.txt_personal_info_access);
//        builder.setMessage(R.string.txt_personal_info_access_content);
//        builder.setCancelable(false);
//
//        builder.setPositiveButton(R.string.txt_agree, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                setPersonalAccess();
//                view.goCameraAccessRight();
//            }
//        });
//        builder.setNegativeButton(R.string.txt_cancel, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(activity, R.string.txt_personal_info_access_right, Toast.LENGTH_SHORT).show();
//                activity.finish();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();

        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.dialog_first_popup);
        dialog.setCancelable(false);

        TextView text = dialog.findViewById(R.id.network_try_again);
        text.setText(R.string.txt_personal_info_access_content);

        Linkify.TransformFilter mTransform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Pattern pattern1 = Pattern.compile("이용 약관");
        Pattern pattern2 = Pattern.compile("개인 정보 보호 정책");

        Linkify.addLinks(text, pattern1, "http://snaptag.com.cn/terms",null,mTransform);
        Linkify.addLinks(text, pattern2, "http://snaptag.com.cn/personal",null,mTransform);


        TextView reject = dialog.findViewById(R.id.alert_tv_button);
        TextView agree = dialog.findViewById(R.id.alert_tv_button2);

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View onView) {
                dialog.dismiss();
                setPersonalAccess();
                view.goCameraAccessRight();
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View onView) {
                Toast.makeText(activity, R.string.txt_personal_info_access_right, Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });
        dialog.show();

    }


}
