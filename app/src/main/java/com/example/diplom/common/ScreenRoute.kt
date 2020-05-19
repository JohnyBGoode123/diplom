package com.example.diplom.common

import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.navController

// надо найти решение из котлина
object ScreenRoute {
    lateinit var listRoute: MutableList<String>
    lateinit var listRouteIterator: Iterator<String>
    @JvmStatic
    fun getNextScreen(): String {
        return if (listRouteIterator.hasNext()) {
            listRouteIterator.next()
        } else {
            "0"
        }

    }

    @JvmStatic
    fun initListRoute(tmpList: MutableList<String>) {
        listRoute = tmpList
        listRouteIterator = listRoute.iterator()
    }
    @JvmStatic
    fun nextScreen()
    {
        Constans.mapScreens[ScreenRoute.getNextScreen()]?.let { it1 ->
            navController?.navigate(
                it1
            )
        };
    }
}
