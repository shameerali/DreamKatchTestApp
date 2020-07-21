package com.example.dreamkatchtestapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDataModel {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("shareable_url")
    @Expose
    private String shareableUrl;
    @SerializedName("formatted_data")
    @Expose
    private FormattedDataModel formattedData;

    public String getMessage() {
        return message;
    }

    public String getShareableUrl() {
        return shareableUrl;
    }

    public FormattedDataModel getFormattedData() {
        return formattedData;
    }
}
