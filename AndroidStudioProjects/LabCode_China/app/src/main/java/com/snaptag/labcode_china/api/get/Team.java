package com.snaptag.labcode_china.api.get;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("title")
    public String title;

    public String getTitle() {
        return title;
    }
}
