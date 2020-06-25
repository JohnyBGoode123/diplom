package com.example.diplom.common.dagger.module

import com.example.diplom.database.AppDataBase
import com.example.diplom.detailedInquiry.DetailedInquiryRepository
import com.example.diplom.detailedInquiry.DetailedInquiryRepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class CoughModule {

    @Provides
    fun coughList(
        dao: AppDataBase
    ): DetailedInquiryRepository = DetailedInquiryRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}