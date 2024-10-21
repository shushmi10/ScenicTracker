package com.example.scenictracker
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ScenicLocationViewModel(private val repository: ScenicLocationRepository) : ViewModel() {

    val allLocations: LiveData<List<ScenicLocation>> = repository.allLocations

    fun insert(location: ScenicLocation) = viewModelScope.launch {
        repository.insert(location)
    }

    fun update(location: ScenicLocation) = viewModelScope.launch {
        repository.update(location)
    }

    fun delete(location: ScenicLocation) = viewModelScope.launch {
        repository.delete(location)
    }
}

class ScenicLocationViewModelFactory(private val repository: ScenicLocationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScenicLocationViewModel::class.java)) {
            return ScenicLocationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
