package com.example.scenictracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlannedTripAdapter(private val trips: List<PlannedTrip>) :
    RecyclerView.Adapter<PlannedTripAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.trip_name)
        val dateTextView: TextView = itemView.findViewById(R.id.trip_date)
        val descriptionTextView: TextView = itemView.findViewById(R.id.trip_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planned_trip, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trip = trips[position]
        holder.nameTextView.text = trip.name
        holder.dateTextView.text = trip.targetDate
        holder.descriptionTextView.text = trip.description
    }

    override fun getItemCount(): Int = trips.size
}
