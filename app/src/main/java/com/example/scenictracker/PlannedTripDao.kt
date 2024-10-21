package com.example.scenictracker
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlannedTripDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrip(trip: PlannedTrip)

    @Update
    suspend fun updateTrip(trip: PlannedTrip)

    @Delete
    suspend fun deleteTrip(trip: PlannedTrip)

    @Query("SELECT * FROM planned_trips ORDER BY targetDate ASC")
    fun getAllPlannedTrips(): LiveData<List<PlannedTrip>>
}
