package com.example.scenictracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddEditTripFragment : Fragment() {

    private lateinit var tripNameEditText: EditText
    private lateinit var tripDescriptionEditText: EditText
    private lateinit var tripDateEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_edit_trip, container, false)

        // Initialize UI components
        tripNameEditText = view.findViewById(R.id.tripNameEditText)
        tripDescriptionEditText = view.findViewById(R.id.tripDescriptionEditText)
        tripDateEditText = view.findViewById(R.id.tripDateEditText)
        saveButton = view.findViewById(R.id.saveButton)

        // Get arguments (to check if adding or editing)
        val tripId = arguments?.getInt("tripId", -1)

        // Set save button functionality
        saveButton.setOnClickListener {
            val tripName = tripNameEditText.text.toString()
            val tripDescription = tripDescriptionEditText.text.toString()
            val tripDate = tripDateEditText.text.toString()

            if (tripId != null && tripId != -1) {
                // Update existing trip
                updateTrip(tripId, tripName, tripDescription, tripDate)
            } else {
                // Add new trip
                addNewTrip(tripName, tripDescription, tripDate)
            }
        }

        return view
    }

    private fun addNewTrip(name: String, description: String, date: String) {
        // Logic to add a new trip
    }

    private fun updateTrip(id: Int, name: String, description: String, date: String) {
        // Logic to update an existing trip
    }
}
