package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DaoSymptoms.Symptoms::class
],
version = 10
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun getDao(): DaoSymptoms
}