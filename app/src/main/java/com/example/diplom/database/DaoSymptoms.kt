package com.example.diplom.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import com.example.diplom.common.models.BodyPartsModel
import com.example.diplom.common.models.SymptomsModel

@Dao
abstract class DaoSymptoms {

//    @Query("SELECT * FROM BodyParts")
//    abstract suspend  fun getAllBodyParts(): List<BodyParts?>

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
        override val selectionMark: Boolean
    ) : SymptomsModel


}