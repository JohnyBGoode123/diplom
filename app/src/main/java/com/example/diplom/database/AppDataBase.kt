package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DaoSymptoms.Symptoms::class,
        DaoSymptoms.ValueSymptoms::class,
        DaoSymptoms.Disease::class,
        DaoSymptoms.VariantSymptomsCrossRef::class,
        DaoSymptoms.ValueSymptomsCertainDisease::class,
        DaoSymptoms.Relevance::class,
        DaoSymptoms.VariantSymptoms::class
],
version = 20
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun getDao(): DaoSymptoms
}