package com.example.scenictracker
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ScenicLocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocation(location: ScenicLocation)

    @Update
    suspend fun updateLocation(location: ScenicLocation)

    @Delete
    suspend fun deleteLocation(location: ScenicLocation)

    @Query("SELECT * FROM scenic_locations ORDER BY name ASC")
    fun getAllScenicLocations(): LiveData<List<ScenicLocation>>
}
