package com.example.templetebbg.di

import com.example.templetebbg.data.Repository
import com.example.templetebbg.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(api: ApiService): Repository = Repository(api)
}