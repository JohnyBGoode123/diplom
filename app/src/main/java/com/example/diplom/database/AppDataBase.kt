package com.example.diplom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Dao.BodyParts::class,
        Dao.Symptoms::class
    ],
    version = 2
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun getDao(): Dao
}