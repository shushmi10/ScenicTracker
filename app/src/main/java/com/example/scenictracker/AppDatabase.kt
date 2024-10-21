package com.example.scenictracker
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ScenicLocation::class, PlannedTrip::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scenicLocationDao(): ScenicLocationDao
    abstract fun plannedTripDao(): PlannedTripDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "scenic_tracker_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
