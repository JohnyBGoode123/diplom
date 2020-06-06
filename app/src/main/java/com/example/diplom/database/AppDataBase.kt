package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DaoSymptoms.Symptoms::class,
        DaoSymptoms.ValueSymptoms::class,
        DaoSymptoms.Disease::class,
        DaoSymptoms.GroupValueSymptomsByDisease::class,
        DaoSymptoms.DirectoryValueSymptoms::class,
        DaoSymptoms.Relevance::class
],
version = 15
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun getDao(): DaoSymptoms
}