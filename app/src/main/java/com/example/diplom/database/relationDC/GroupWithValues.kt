package com.example.diplom.database.relationDC

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diplom.database.DaoSymptoms

data class GroupWithValues(
    @Embedded val group: DaoSymptoms.GroupValueSymptoms,
    @Relation(
        parentColumn = "idGroup",
        entityColumn = "idGroup"
    )
    val value: List<DaoSymptoms.ValueSymptoms>
)