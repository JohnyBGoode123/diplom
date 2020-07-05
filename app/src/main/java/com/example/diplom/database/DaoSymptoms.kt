package com.example.diplom.database

import androidx.room.*
import com.example.diplom.common.models.*
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms
import com.example.diplom.database.relationDC.GroupWithValues

@Dao
abstract class DaoSymptoms {
    @Query("SELECT COUNT(*) FROM Symptoms")
    abstract suspend fun getCountLinesSymptoms(): Int

    @Query("SELECT distinct * FROM Symptoms Where bodyParts = :nameBodyPart ")
    abstract suspend fun getSymptomsByBodyPart(nameBodyPart: String): List<Symptoms>

    @Query("SELECT * FROM Symptoms")
    abstract suspend fun getAllSymptoms(): List<Symptoms>

    @Query("SELECT title FROM Symptoms where id = :idSymptom")
    abstract suspend fun getTitleSymptoms(idSymptom: Int): String

    @Query("SELECT * FROM ValueSymptoms Where idGroupValue = :idValue ")
    abstract suspend fun getTMPValueSymptoms(idValue: Int): List<ValueSymptoms>

    @Query("SELECT * FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getAllChosenSymptoms(): List<Symptoms>


    @Query("SELECT  nameSymptom FROM Symptoms Where selectionMark = 1 ")
    abstract suspend fun getNameChosenSymptoms(): List<String>

    @Query("SELECT DISTINCT bodyParts FROM Symptoms")
    abstract suspend fun getBodyParts(): List<String>

    @Query("SELECT DISTINCT nameSymptom FROM Symptoms")
    abstract suspend fun getNameSymptoms(): List<String>


    @Query("SELECT * FROM Disease Where idDisease = :id")
    abstract suspend fun getChosenDisease(id: Int): List<Disease>

    @Query("SELECT * FROM GroupValueSymptoms Where idGroup = :id")
    abstract suspend fun getGroup(id: Int): List<GroupValueSymptoms>

    @Query("Update Symptoms Set selectionMark = 0")
    abstract suspend fun setSymptomSmFalse()


    @Transaction
    @Query("SELECT * FROM Disease")
    abstract suspend fun getDiseaseWithVariant(): List<DiseaseWithVariantSymptoms>

    @Transaction
    @Query("SELECT * FROM GroupValueSymptoms Where idSymptom = :idSymptom")
    abstract suspend fun getGroupWithValues(idSymptom: Int): List<GroupWithValues>


    @Update
    abstract suspend fun updateSymptoms(symptoms: List<Symptoms>?)

    @Update
    abstract suspend fun updateOneDeletedSymptom(symptoms: Symptoms)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertSymptoms(symptoms: MutableCollection<Symptoms>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertValueSymptoms(symptoms: MutableCollection<ValueSymptoms>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertDisease(symptoms: MutableCollection<Disease>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertGroupValueSymptoms(symptoms: MutableCollection<GroupValueSymptoms>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertVariantSymptomsCrossRef(symptoms: MutableCollection<VariantSymptomsCrossRef>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertVariantSymptoms(symptoms: MutableCollection<VariantSymptoms>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertRelevance(symptoms: MutableCollection<Relevance>)

    @Entity
    class Symptoms(
        @PrimaryKey
        override val id: Int,
        override val nameSymptom: String,
        override val bodyParts: String,
        override var selectionMark: Boolean,
        override val title: String?
    ) : SymptomsModel

    @Entity
    class GroupValueSymptoms(
        @PrimaryKey
        override val idGroup: Int,
        override val idSymptom: Int
    ):GroupValueSymptomsModel

    @Entity
    class ValueSymptoms(
        @PrimaryKey
        override val id: Int,
        override val nameValue: String,
        override val idGroupValue: Int
    ) : ValueSymptomsModel

    @Entity
    class Disease(
        @PrimaryKey
        override val idDisease: Int,
        override val nameDisease: String,
        override val doctorCall: String,
        override val recommendation: String
    ) : DiseaseModel

    @Entity(primaryKeys = ["idDisease", "idVariant"])
    class VariantSymptomsCrossRef(
        override val idDisease: Int,
        override val idVariant: Int
    ) : DiseaseModelSymptoms

    @Entity
    class VariantSymptoms(
        @PrimaryKey
        override val idVariant: Int,
        override val idSymptom: Int,
        override val idValue: Int?,
        override val idRelevance: Int
    ) : VariantSymptomsModel

    @Entity
    class Relevance(
        @PrimaryKey
        override val id: Int,
        override val nameRelevance: String
    ) : RelevanceModel


}