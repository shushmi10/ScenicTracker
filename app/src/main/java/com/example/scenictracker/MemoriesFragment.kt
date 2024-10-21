package com.example.scenictracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button


class MemoriesFragment : Fragment() {

    private lateinit var scenicLocationAdapter: ScenicLocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_memories, container, false)
        val addButton: Button = view.findViewById(R.id.addMemoryButton)

        scenicLocationAdapter = ScenicLocationAdapter(
            onEdit = { memory -> navigateToAddEditFragment(memory) },
            onDelete = { memory -> deleteMemory(memory) }
        )

        // RecyclerView setup
        val recyclerView: RecyclerView = view.findViewById(R.id.memoriesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = scenicLocationAdapter

        addButton.setOnClickListener {
            navigateToAddEditFragment(null) // Pass null for adding a new memory
        }

        // Load data
        loadSampleData()

        return view
    }

    private fun navigateToAddEditFragment(memory: ScenicLocation?) {
        // Use navigation component to navigate to AddEditTripFragment
    }

    private fun deleteMemory(memory: ScenicLocation) {
        // Delete the memory from your data source
    }

    private fun loadSampleData() {
        val sampleLocations = listOf(
            ScenicLocation(1, "Great Ocean Road", "Beautiful coastal drive.", "image_url", 5, "coast"),
            ScenicLocation(2, "Grampians", "Fantastic hiking location.", "image_url", 4, "hiking, mountains")
        )
        scenicLocationAdapter.setLocations(sampleLocations)
    }
}
