package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DaoSymptoms.BodyParts::class,
        DaoSymptoms.Symptoms::class
],
version = 7
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun getDao(): DaoSymptoms
}