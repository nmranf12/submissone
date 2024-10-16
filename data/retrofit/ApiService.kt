package com.dicoding.submissone.data.retrofit

import com.dicoding.submissone.data.response.EventListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("events?active=1") // URL untuk mengambil acara yang akan datang
    suspend fun getUpcomingEvents(): Response<EventListResponse>

    @GET("events?active=0") // URL untuk mengambil acara yang lalu
    suspend fun getPastEvents(): Response<EventListResponse>
}
