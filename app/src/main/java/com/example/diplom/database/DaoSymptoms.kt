package com.example.diplom.database

import androidx.room.*
import com.example.diplom.common.models.BodyPartsModel
import com.example.diplom.common.models.SymptomsModel

@Dao
abstract class DaoSymptoms {

    @Query("SELECT * FROM Symptoms Where idBodyParts = :nameBodyPart ")
    abstract suspend  fun getSymptomsByBodyPart(nameBodyPart: String): List<Symptoms>

    @Query("SELECT * FROM Symptoms")
    abstract suspend  fun getAllSymptoms(): List<Symptoms>

    @Query("SELECT * FROM Symptoms Where selectionMark = 1 ")
    abstract suspend  fun getAllChosenSymptoms(): List<Symptoms>

    @Update
    abstract suspend fun updateSymptoms(symptoms: List<Symptoms>?)
    @Update
    abstract suspend fun updateOneDeletedSymptom(symptoms: Symptoms)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertSymptoms(symptoms: MutableCollection<Symptoms>)
    @Entity
    class BodyParts(
        @PrimaryKey
        override val bodyPartsName: String
    ) : BodyPartsModel

    @Entity
    class Symptoms(
        @PrimaryKey
        override val nameSymptom: String,
        override val idBodyParts: String,
        override var selectionMark: Boolean
    ) : SymptomsModel


}