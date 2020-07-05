package com.example.diplom.common.dagger.module

import com.example.diplom.common.models.ValueSymptomsModel

data class DetailedRequestScreenModule (
    val titleScreen: String,
    val listValue: List<ValueSymptomsModel>
)