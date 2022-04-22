package com.snaptag.labcode_china.navigation.list.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

import com.snaptag.labcode_china.navigation.list.model.ListModel;
import com.snaptag.labcode_china.network.NetworkCheck;

public class ListPresenter implements ListContract.Presenter, NetworkCheck.Presenter {

    ListContract.View view;
    ListModel model;

    public ListPresenter(ListContract.View view){
        this.view = view;
        model = new ListModel(this);
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

    @Override
    public void checkListData() {
        if (model.getList()){ view.goList(); }
        else { view.goBlank(); }

        }

    }

