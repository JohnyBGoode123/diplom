package com.example.diplom.common.jsonClasses


data class DCRelevance (

    val arrayRelevance : List<ArrayRelevance>
)
data class ArrayRelevance (

    val id : Int,
    val name : String
)