package com.example.scenictracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planned_trips")
data class PlannedTrip(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // Auto-generated primary key
    val name: String,
    val description: String,
    val targetDate: String  // Future date as a string
)