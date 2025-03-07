package com.ohmz.reminder.di

import com.ohmz.reminder.data.local.AppDatabase
import com.ohmz.reminder.data.repository.ReminderRepository
import com.ohmz.reminder.data.repository.ReminderRepositoryImpl
import dagger.Module
import dagger.Binds
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// In AppModule.kt
@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    abstract fun bindRepository(impl: ReminderRepositoryImpl): ReminderRepository
}


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideReminderRepository(db: AppDatabase): ReminderRepository {
        return ReminderRepositoryImpl(db)
    }
}