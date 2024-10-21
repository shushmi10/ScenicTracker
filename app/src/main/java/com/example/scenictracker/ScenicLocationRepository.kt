package com.example.scenictracker
import androidx.lifecycle.LiveData

class ScenicLocationRepository(private val dao: ScenicLocationDao) {

    val allLocations: LiveData<List<ScenicLocation>> = dao.getAllScenicLocations()

    suspend fun insert(location: ScenicLocation) {
        dao.insertLocation(location)
    }

    suspend fun update(location: ScenicLocation) {
        dao.updateLocation(location)
    }

    suspend fun delete(location: ScenicLocation) {
        dao.deleteLocation(location)
    }
}
