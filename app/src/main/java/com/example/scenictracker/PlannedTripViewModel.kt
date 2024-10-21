package com.example.scenictracker
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PlannedTripViewModel(private val repository: PlannedTripRepository) : ViewModel() {

    val allPlannedTrips: LiveData<List<PlannedTrip>> = repository.allPlannedTrips

    fun insert(trip: PlannedTrip) = viewModelScope.launch {
        repository.insert(trip)
    }

    fun update(trip: PlannedTrip) = viewModelScope.launch {
        repository.update(trip)
    }

    fun delete(trip: PlannedTrip) = viewModelScope.launch {
        repository.delete(trip)
    }
}

class PlannedTripViewModelFactory(private val repository: PlannedTripRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlannedTripViewModel::class.java)) {
            return PlannedTripViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
