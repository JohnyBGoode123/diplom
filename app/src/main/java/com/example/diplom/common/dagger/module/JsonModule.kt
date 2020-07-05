package com.example.diplom.common.dagger.module

import com.example.diplom.common.App
import com.example.diplom.common.JsonTransfer
import dagger.Module
import dagger.Provides

@Module
class JsonModule {
    @Provides
    fun json(): JsonTransfer =
        App.instance.getContext().let { JsonTransfer(it) }
}
