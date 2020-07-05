package com.example.diplom.common.dagger.module

import com.example.diplom.database.AppDataBase
import com.example.diplom.detailedRequest.DetailedRequestRepository
import com.example.diplom.detailedRequest.DetailedRequestRepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class DetailedRequestModule {
    @Provides
    fun detailedRequestList(
        dao: AppDataBase
    ): DetailedRequestRepository = DetailedRequestRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}