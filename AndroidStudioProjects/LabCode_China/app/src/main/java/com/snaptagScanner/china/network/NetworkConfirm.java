package com.snaptagScanner.china.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class NetworkConfirm {

    private static NetworkConfirm instance;

    private NetworkConfirm(){}

    public static NetworkConfirm getInstance(){
        if(instance == null){
            instance = new NetworkConfirm();
        }

        return instance;
    }

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

        return confirm;
    }
}
