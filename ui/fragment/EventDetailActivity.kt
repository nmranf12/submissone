package com.dicoding.submissone.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.submissone.data.response.EventResponse
import com.dicoding.submissone.databinding.ActivityEventDetailBinding

@Suppress("DEPRECATION")
class EventDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the EventResponse object from the Intent
        val event = intent.getParcelableExtra<EventResponse>("EVENT_DATA")

        // Populate the UI with the event data
        event?.let {
            Glide.with(this).load(it.image).into(binding.imageView)
            binding.textViewName.text = it.name
            binding.textViewOwner.text = it.ownerName
            binding.textViewTime.text = it.beginTime
            binding.textViewQuota.text = (it.quota - it.registrant).toString()
            binding.textViewDescription.text = it.description
        } ?: run {
            // Handle the case where event data is null
            binding.textViewName.text = "Event not found"
            binding.textViewOwner.text = ""
            binding.textViewTime.text = ""
            binding.textViewQuota.text = ""
            binding.textViewDescription.text = "No details available."
        }
    }
}
