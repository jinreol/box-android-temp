package com.example.sunflower.data

import androidx.room.Dao

@Dao
interface GardenPlantingDao {
//    @Query("SELECT * FROM garden_plantings")
//    fun getGardenPlantings(): Flow<List<GardenPlanting>>
//
//    /**
//     * This query will tell Room to query both the [Plant] and [GardenPlanting] tables and handle
//     * the object mapping.
//     */
//    @Transaction
//    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
//    fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>>
}