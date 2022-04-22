package com.snaptag.labcode_china.main.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

import com.snaptag.labcode_china.network.NetworkCheck;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.main.model.MainModel;

public class MainPresenter implements MainContract.Presenter, NetworkCheck.Presenter {

    MainModel model;
    MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public void controlFragment(int item, Context context) {
        if (confirmNetwork(context)){
            switch (item){
                case R.id.page_scan : view.callScan(); break;
                case R.id.page_list : view.callList(); break;
                case R.id.page_more : view.callMore(); break;
            }
        } else {
            view.networkError();
        }
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

        return confirm;
    }
}
