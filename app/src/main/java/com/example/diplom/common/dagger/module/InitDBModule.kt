package com.example.diplom.common.dagger.module

import android.content.Context
import com.example.diplom.common.App
import com.example.diplom.common.JsonTransfer
import com.example.diplom.database.AppDataBase
import com.example.diplom.database.InitDB
import dagger.Module
import dagger.Provides

@Module
class InitDBModule {
    @Provides
   fun initDB(dao: AppDataBase): InitDB =
        InitDB(dao.getDao(), App.repositories.json())
}