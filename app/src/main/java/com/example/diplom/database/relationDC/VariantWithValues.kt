package com.example.diplom.database.relationDC

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diplom.database.DaoSymptoms

data class VariantWithValues (
    @Embedded val id: DaoSymptoms.VariantSymptoms,
    @Relation(
        parentColumn = "idVariant",
        entityColumn = "idVariant"
    )
    val variants: List<DaoSymptoms.ValueSymptomsCertainDisease>
)