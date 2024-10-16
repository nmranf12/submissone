package com.dicoding.submissone.data.response

import com.google.gson.annotations.SerializedName

data class EventListResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("events") val events: List<EventResponse>
)
