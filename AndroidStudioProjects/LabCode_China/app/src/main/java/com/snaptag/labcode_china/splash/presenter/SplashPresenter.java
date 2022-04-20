package com.snaptag.labcode_china.splash.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import com.snaptag.labcode_china.splash.model.SplashModel;

public class SplashPresenter implements SplashContract.Presenter {

    static String thisName = "SplashPresenter";

    SplashContract.View view;
    SplashModel model;

    public SplashPresenter(SplashContract.View view){
        this.view = view;
        model = new SplashModel(this);
    }

    @Override
    public void splashHandler(int sec, Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (confirmNetwork(context)){
                    view.startMain();
                }
                else {
                    view.finishApp();
                }
            }
        }, 1000 * sec);
    }

    @Override
    public boolean confirmNetwork(Context context) {

        boolean confirm = false;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (manager != null) {
                NetworkCapabilities capabilities = manager.getNetworkCapabilities(manager.getActiveNetwork());
                if (capabilities != null) {
                    confirm = capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
                }
            }
        } else {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();   //getActiveNetworkInfo는 29버전부터 deplecated.
            if (networkInfo != null) {
                confirm = (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) || (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
                // TYPE_WIFI, TYPE_MOBILE는 28버전부터 deplecated.
            }
        }

        Log.d(thisName,"confirm value : "+Boolean.toString(confirm));

        return confirm;
    }

}
