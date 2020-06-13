package com.example.diplom.database.relationDC

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diplom.database.DaoSymptoms

data class DiseaseWithVariantSymptoms(
    @Embedded val disease: DaoSymptoms.Disease,
    @Relation(
        entity = DaoSymptoms.VariantSymptoms::class,
        parentColumn = "idDisease",
        entityColumn = "idVariant",
        associateBy = Junction(DaoSymptoms.VariantSymptomsCrossRef::class)
    )
    val variant: List<DaoSymptoms.VariantSymptoms>

)
