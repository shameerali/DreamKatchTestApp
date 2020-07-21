package com.example.dreamkatchtestapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormattedDataModel {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("data_type")
    @Expose
    private String dataType;
    @SerializedName("contest_id")
    @Expose
    private Integer contestId;
    @SerializedName("user_media_type")
    @Expose
    private String userMediaType;
    @SerializedName("is_adult_content")
    @Expose
    private Boolean isAdultContent;
    @SerializedName("brief_description")
    @Expose
    private String briefDescription;
    @SerializedName("contest_file_type")
    @Expose
    private String contestFileType;
    @SerializedName("complete_description")
    @Expose
    private String completeDescription;
    @SerializedName("image_large_thumbnail")
    @Expose
    private String imageLargeThumbnail;
    @SerializedName("image_small_thumbnail")
    @Expose
    private String imageSmallThumbnail;

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getVideo() {
        return video;
    }

    public String getDataType() {
        return dataType;
    }

    public Integer getContestId() {
        return contestId;
    }

    public String getUserMediaType() {
        return userMediaType;
    }

    public Boolean getAdultContent() {
        return isAdultContent;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getContestFileType() {
        return contestFileType;
    }

    public String getCompleteDescription() {
        return completeDescription;
    }

    public String getImageLargeThumbnail() {
        return imageLargeThumbnail;
    }

    public String getImageSmallThumbnail() {
        return imageSmallThumbnail;
    }
}
