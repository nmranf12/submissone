package com.dicoding.submissone.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissone.R
import com.dicoding.submissone.data.response.EventResponse

class EventAdapter(
    private var events: List<EventResponse>,
    private val onClick: (EventResponse) -> Unit // Lambda untuk menangani click event
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventName: TextView = itemView.findViewById(R.id.eventNameTextView) // Pastikan ID ini sesuai dengan layout Anda

        fun bind(event: EventResponse) {
            eventName.text = event.name // Mengatur nama event ke TextView
            itemView.setOnClickListener { onClick(event) } // Menangani klik item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false) // Ganti dengan layout item Anda
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position]) // Mengikat data event ke ViewHolder
    }

    override fun getItemCount(): Int = events.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateEvents(newEvents: List<EventResponse>) {
        events = newEvents
        notifyDataSetChanged()
    }
}
