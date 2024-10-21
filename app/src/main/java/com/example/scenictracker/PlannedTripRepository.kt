package com.example.scenictracker
import androidx.lifecycle.LiveData

class PlannedTripRepository(private val dao: PlannedTripDao) {

    val allPlannedTrips: LiveData<List<PlannedTrip>> = dao.getAllPlannedTrips()

    suspend fun insert(trip: PlannedTrip) {
        dao.insertTrip(trip)
    }

    suspend fun update(trip: PlannedTrip) {
        dao.updateTrip(trip)
    }

    suspend fun delete(trip: PlannedTrip) {
        dao.deleteTrip(trip)
    }
}

