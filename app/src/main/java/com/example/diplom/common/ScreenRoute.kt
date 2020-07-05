package com.example.diplom.common

import androidx.core.os.bundleOf
import com.example.diplom.navController

// надо найти решение из котлина
object ScreenRoute {
    lateinit var listRoute: MutableList<Int>
    lateinit var listRouteIterator: Iterator<Int>



    @JvmStatic
    fun getNextScreen(): Int {
        return if (listRouteIterator.hasNext()) {
            listRouteIterator.next()
        } else {
            0
        }
    }

    @JvmStatic
    fun initListRoute(tmpList: MutableList<Int>) {
        listRoute = tmpList
        listRouteIterator = listRoute.iterator()
    }

    @JvmStatic
    fun nextScreen() {
        val arg = getNextScreen()
        val bundle = bundleOf("args" to arg)
        Constants.mapScreens[arg]?.let { it1 ->
            navController?.navigate(
                it1, bundle
            )
        };
    }
}
