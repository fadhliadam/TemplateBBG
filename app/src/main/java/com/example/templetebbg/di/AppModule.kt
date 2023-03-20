package com.example.templetebbg.di

import com.example.templetebbg.data.Repository
import com.example.templetebbg.data.remote.ApiService
import dagger.Provides
import javax.inject.Singleton

class AppModule {

    @Provides
    @Singleton
    fun repository(api: ApiService): Repository = Repository(api)
}