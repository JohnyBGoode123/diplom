package com.example.diplom.database

import androidx.room.*
import com.example.diplom.common.models.BodyPartsModel
import com.example.diplom.common.models.SymptomsModel

@Dao
abstract class DaoSymptoms {

    @Query("SELECT * FROM Symptoms Where bodyParts = :nameBodyPart ")
    abstract suspend fun getSymptomsByBodyPart(nameBodyPart: String): List<Symptoms>

    @Query("SELECT * FROM Symptoms")
    abstract suspend fun getAllSymptoms(): List<Symptoms>

    @Query("SELECT * FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getAllChosenSymptoms(): List<Symptoms>

    @Query("SELECT DISTINCT bodyParts FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getIdScreenChosenSymptoms(): List<String>


    @Update
    abstract suspend fun updateSymptoms(symptoms: List<Symptoms>?)

    @Update
    abstract suspend fun updateOneDeletedSymptom(symptoms: Symptoms)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertSymptoms(symptoms: MutableCollection<Symptoms>)

    @Entity
    class Symptoms(
        @PrimaryKey
        override val nameSymptom: String,
        override val bodyParts: String,
        override var selectionMark: Boolean
    ) : SymptomsModel


}