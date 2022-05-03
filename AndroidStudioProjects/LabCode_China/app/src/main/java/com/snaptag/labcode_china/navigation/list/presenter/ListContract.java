package com.snaptag.labcode_china.navigation.list.presenter;


import com.snaptag.labcode_china.navigation.list.data.ListItemData;

public interface ListContract {

    interface View{
        void goBlank();
        void goList();
        void goDetail();
    }

    interface Presenter{
        void controlView();
        void testView();
        void testView2();
    }

}
