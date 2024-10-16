package com.dicoding.submissone.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissone.R
import com.dicoding.submissone.adapter.EventAdapter
import com.dicoding.submissone.ui.EventViewModel

class PastEventsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: EventViewModel by viewModels()
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_past_events, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = EventAdapter(emptyList()) { /* Handle click event */ }
        recyclerView.adapter = adapter

        observeViewModel()
        return view
    }

    private fun observeViewModel() {
        viewModel.fetchPastEvents()
        viewModel.pastEvents.observe(viewLifecycleOwner) { events ->
            adapter.updateEvents(events)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Log.e("PastEventsFragment", it) // Log the error
                // Show error message (Toast or Snackbar)
            }
        }
    }
}
