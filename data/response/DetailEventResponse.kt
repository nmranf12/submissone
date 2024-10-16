package com.dicoding.submissone.data.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DetailEventResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String? = null, // Nullable dengan default null

    @field:SerializedName("image")
    val image: String? = null, // Nullable dengan default null

    @field:SerializedName("description")
    val description: String? = null, // Nullable dengan default null

    @field:SerializedName("ownerName")
    val ownerName: String? = null, // Nullable dengan default null

    @field:SerializedName("beginTime")
    val beginTime: String? = null, // Nullable dengan default null

    @field:SerializedName("quota")
    val quota: Int,

    @field:SerializedName("registrant")
    val registrant: Int,

    @field:SerializedName("link")
    val link: String? = null // Nullable dengan default null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "", // Menggunakan string default kosong
        parcel.readString(), // Nullable
        parcel.readString(), // Nullable
        parcel.readString(), // Nullable
        parcel.readString(), // Nullable
        parcel.readString(), // Nullable
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() // Nullable
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeString(ownerName)
        parcel.writeString(beginTime)
        parcel.writeInt(quota)
        parcel.writeInt(registrant)
        parcel.writeString(link)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<DetailEventResponse> {
        override fun createFromParcel(parcel: Parcel): DetailEventResponse {
            return DetailEventResponse(parcel)
        }

        override fun newArray(size: Int): Array<DetailEventResponse?> {
            return arrayOfNulls(size)
        }
    }
}
