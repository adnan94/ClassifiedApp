package com.example.classifieds.data.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ClassifiedItem implements Parcelable {

    @SerializedName("created_at")
    public String created_at;

    @SerializedName("price")
    public String price;

    @SerializedName("name")
    public String name;

    @SerializedName("uid")
    public String uid;

    @SerializedName("image_ids")
    public ArrayList<String> image_ids;

    @SerializedName("image_urls")
    public ArrayList<String> image_urls;

    @SerializedName("image_urls_thumbnails")
    public ArrayList<String> image_urls_thumbnails;

    protected ClassifiedItem(Parcel in) {
        created_at = in.readString();
        price = in.readString();
        name = in.readString();
        uid = in.readString();
        image_ids = in.createStringArrayList();
        image_urls = in.createStringArrayList();
        image_urls_thumbnails = in.createStringArrayList();
    }

    public static final Creator<ClassifiedItem> CREATOR = new Creator<ClassifiedItem>() {
        @Override
        public ClassifiedItem createFromParcel(Parcel in) {
            return new ClassifiedItem(in);
        }

        @Override
        public ClassifiedItem[] newArray(int size) {
            return new ClassifiedItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created_at);
        dest.writeString(price);
        dest.writeString(name);
        dest.writeString(uid);
        dest.writeStringList(image_ids);
        dest.writeStringList(image_urls);
        dest.writeStringList(image_urls_thumbnails);
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<String> getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(ArrayList<String> image_ids) {
        this.image_ids = image_ids;
    }

    public ArrayList<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(ArrayList<String> image_urls) {
        this.image_urls = image_urls;
    }

    public ArrayList<String> getImage_urls_thumbnails() {
        return image_urls_thumbnails;
    }

    public void setImage_urls_thumbnails(ArrayList<String> image_urls_thumbnails) {
        this.image_urls_thumbnails = image_urls_thumbnails;
    }

    public static Creator<ClassifiedItem> getCREATOR() {
        return CREATOR;
    }
}
