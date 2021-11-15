package com.example.classifieds.data.pojos

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ClassifiedItemKt(parcel: Parcel) : Parcelable {

    @SerializedName("created_at")
    val created_at: String? = null

    @SerializedName("price")
    val price: String? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("uid")
    val uid: String? = null

    @SerializedName("image_ids")
    val image_ids: List<String>? = null

    @SerializedName("image_urls")
    var image_urls: List<String>? = null

    @SerializedName("image_urls_thumbnails")
    val image_urls_thumbnails: List<String>? = null


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(created_at)
        dest.writeString(price)
        dest.writeString(name)
        dest.writeString(uid)
        dest.writeStringList(image_urls)
    }

    protected fun ClassifiedItemKt(`in`: Parcel) {
        image_urls = `in`.createStringArray()?.toList()
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ClassifiedItemKt> {
        override fun createFromParcel(parcel: Parcel): ClassifiedItemKt{
            return ClassifiedItemKt(parcel)
        }

        override fun newArray(size: Int): Array<ClassifiedItemKt?> {
            return arrayOfNulls(size)
        }
    }

}