package com.example.diplom.detailedRequest

import android.icu.text.CaseMap
import com.example.diplom.common.dagger.module.DetailedRequestScreenModule
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.database.relationDC.GroupWithValues

object DetailedRequestUtils {
    lateinit var listGroup: List<GroupWithValues>
    lateinit var listGroupIterator: Iterator<GroupWithValues>

    lateinit var listSymptom: List<Int>
    lateinit var listRouteSymptom: Iterator<Int>

    var listScreen: MutableList<DetailedRequestScreenModule> = mutableListOf()
    var currentItemListScreen = 0
    @JvmStatic
    fun getNextGroup(): GroupWithValues? {
        return if (listGroupIterator.hasNext()) {
            listGroupIterator.next()
        } else {
            null
        }
    }
    @JvmStatic
    fun initListGroup(tmpList: List<GroupWithValues>) {
        listGroup = tmpList
        listGroupIterator = listGroup.iterator()

    }


    @JvmStatic
    fun getNextSymptom(): Int {
        return if (listRouteSymptom.hasNext()) {
            listRouteSymptom.next()
        } else {
            0
        }
    }

    @JvmStatic
    fun initListSymptom(tmpList: List<Int>) {
        listSymptom = tmpList
        listRouteSymptom = listSymptom.iterator()
    }
    @JvmStatic
    fun setListScreen(title: String, list: List<ValueSymptomsModel>) {
        currentItemListScreen++
        listScreen.add(DetailedRequestScreenModule(title,list))
    }
}