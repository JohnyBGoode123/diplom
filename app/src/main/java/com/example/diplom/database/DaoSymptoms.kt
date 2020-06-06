package com.example.diplom.database

import androidx.room.*
import com.example.diplom.common.models.*

@Dao
abstract class DaoSymptoms {

    @Query("SELECT * FROM Symptoms Where bodyParts = :nameBodyPart ")
    abstract suspend fun getSymptomsByBodyPart(nameBodyPart: String): List<Symptoms>

    @Query("SELECT * FROM Symptoms")
    abstract suspend fun getAllSymptoms(): List<Symptoms>

    @Query("SELECT * FROM ValueSymptoms")
    abstract suspend fun getAllValueSymptoms(): List<ValueSymptoms>

    @Query("SELECT * FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getAllChosenSymptoms(): List<Symptoms>

    @Query("SELECT  nameSymptom FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getIdScreenChosenSymptoms(): List<String>

    @Query("SELECT DISTINCT bodyParts FROM Symptoms")
    abstract suspend fun getBodyParts(): List<String>

    @Query("SELECT DISTINCT nameSymptom FROM Symptoms")
    abstract suspend fun getNameSymptoms(): List<String>


    @Update
    abstract suspend fun updateSymptoms(symptoms: List<Symptoms>?)

    @Update
    abstract suspend fun updateOneDeletedSymptom(symptoms: Symptoms)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertSymptoms(symptoms: MutableCollection<Symptoms>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertValueSymptoms(symptoms: MutableCollection<ValueSymptoms>)

    @Entity
    class Symptoms(
        @PrimaryKey
        override val id: Int,
        override val nameSymptom: String,
        override val bodyParts: String,
        override var selectionMark: Boolean
    ) : SymptomsModel

    @Entity
    class ValueSymptoms(
        @PrimaryKey
        override val id: Int,
        override val nameValue: String,
        override val idSymptoms: Int
    ) : ValueSymptomsModel
    @Entity
    class Disease(
        @PrimaryKey
        override val id: Int,
        override val nameDisease: String,
        override val linkDiagnosis: Int
    ) : DiseaseModel
    @Entity
    class GroupValueSymptomsByDisease(
        @PrimaryKey
        override val id: Int,
        override val idSymptoms: Int,
        override val idDisease: Int
    ) : GroupValueSymptomsByDiseaseModel
    @Entity
    class DirectoryValueSymptoms(
        @PrimaryKey
        override val id: Int,
        override val idSymptom: Int,
        override val idRelevance: Int
    ) : DirectoryValueSymptomsModel
    @Entity
    class Relevance(
        @PrimaryKey
        override val id: Int,
        override val nameRelevance: String
    ) : RelevanceModel



}