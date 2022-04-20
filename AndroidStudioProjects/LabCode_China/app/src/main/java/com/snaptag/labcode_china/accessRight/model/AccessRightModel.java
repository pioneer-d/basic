package com.snaptag.labcode_china.accessRight.model;

import com.snaptag.labcode_china.accessRight.presenter.AccessRightContract;

public class AccessRightModel {

    AccessRightContract.Presenter presenter;

    public AccessRightModel(AccessRightContract.Presenter presenter){
        this.presenter = presenter;

    }

}
