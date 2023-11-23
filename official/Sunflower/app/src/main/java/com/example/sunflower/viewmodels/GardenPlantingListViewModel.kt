package com.example.sunflower.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sunflower.data.GardenPlantingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GardenPlantingListViewModel @Inject internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
//    val plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>> =
//        gardenPlantingRepository.getPlantedGardens()

    fun testPrint() {
        Log.d("GardenPlantingListViewModel", "Test Print() - 01")
    }
}