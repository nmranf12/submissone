package com.dicoding.submissone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissone.data.response.EventResponse
import com.dicoding.submissone.data.retrofit.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventViewModel : ViewModel() {

    private val _upcomingEvents = MutableLiveData<List<EventResponse>>()
    val upcomingEvents: LiveData<List<EventResponse>> = _upcomingEvents

    private val _pastEvents = MutableLiveData<List<EventResponse>>()
    val pastEvents: LiveData<List<EventResponse>> = _pastEvents

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://event-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun fetchUpcomingEvents() {
        viewModelScope.launch {
            try {
                val response = apiService.getUpcomingEvents()
                if (response.isSuccessful) {
                    _upcomingEvents.value = response.body()?.events ?: emptyList()
                    _error.value = null
                } else {
                    _error.value = "Gagal memuat acara yang akan datang: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }

    fun fetchPastEvents() {
        viewModelScope.launch {
            try {
                val response = apiService.getPastEvents()
                if (response.isSuccessful) {
                    _pastEvents.value = response.body()?.events ?: emptyList()
                    _error.value = null
                } else {
                    _error.value = "Gagal memuat acara yang lalu: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }
}
