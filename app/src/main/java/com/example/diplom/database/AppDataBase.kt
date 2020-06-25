package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DaoSymptoms.Symptoms::class,
        DaoSymptoms.ValueSymptoms::class,
        DaoSymptoms.Disease::class,
        DaoSymptoms.VariantSymptomsCrossRef::class,
        DaoSymptoms.Relevance::class,
        DaoSymptoms.VariantSymptoms::class,
        DaoSymptoms.GroupValueSymptoms::class
    ],
    version = 28
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): DaoSymptoms
}