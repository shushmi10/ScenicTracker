package com.example.scenictracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlannedTripsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_planned_trips, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.plannedTripsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample data
        val sampleTrips = listOf(
            PlannedTrip(id = 1, name = "Trip to Wilsons Promontory", description = "Explore the beauty of nature", targetDate = "2024-12-10"),
            PlannedTrip(id = 2, name = "Visit Phillip Island", description = "See the penguin parade", targetDate = "2024-11-18")
        )

        // Initialize adapter with sample data
        val plannedTripAdapter = PlannedTripAdapter(sampleTrips)
        recyclerView.adapter = plannedTripAdapter

        return view
    }
}
