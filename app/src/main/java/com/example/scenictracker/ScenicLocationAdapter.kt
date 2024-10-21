package com.example.scenictracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScenicLocationAdapter(
    private val onEdit: (ScenicLocation) -> Unit,
    private val onDelete: (ScenicLocation) -> Unit
) : RecyclerView.Adapter<ScenicLocationAdapter.ViewHolder>() {

    private var locations = emptyList<ScenicLocation>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.location_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.location_description)
        val imageView: ImageView = itemView.findViewById(R.id.memoryImageView)  // Correct import and usage of ImageView
        val editButton: ImageButton = itemView.findViewById(R.id.editButton)    // Correct import and usage of ImageButton
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)  // Correct import and usage of ImageButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memory, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locations[position]
        holder.nameTextView.text = location.name
        holder.descriptionTextView.text = location.description

        // Handle edit button click
        holder.editButton.setOnClickListener {
            onEdit(location)
        }

        // Handle delete button click
        holder.deleteButton.setOnClickListener {
            onDelete(location)
        }
    }

    override fun getItemCount(): Int = locations.size

    fun setLocations(newLocations: List<ScenicLocation>) {
        locations = newLocations
        notifyDataSetChanged()
    }
}
