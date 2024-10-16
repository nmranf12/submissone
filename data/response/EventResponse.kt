package com.dicoding.submissone.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventResponse(
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("ownerName")
	val ownerName: String,

	@field:SerializedName("beginTime")
	val beginTime: String,

	@field:SerializedName("quota")
	val quota: Int,

	@field:SerializedName("registrant")
	val registrant: Int,

	@field:SerializedName("link")
	val link: String
) : Parcelable