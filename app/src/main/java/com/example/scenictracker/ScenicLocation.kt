package com.example.scenictracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scenic_locations")
data class ScenicLocation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // Auto-generated primary key
    val name: String,
    val description: String,
    val imageUrl: String,
    val rating: Int,  // Rating out of 5
    val tags: String  // Comma-separated tags
)