package com.jadhavrupesh22.hilt_base.di

import com.jadhavrupesh22.hilt_base.repo.MainRepository
import com.jadhavrupesh22.hilt_base.room.BlogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
    ): MainRepository {
        return MainRepository(blogDao)
    }
}