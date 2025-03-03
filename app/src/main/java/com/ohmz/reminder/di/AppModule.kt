package com.ohmz.reminder.di

import com.google.android.datatransport.runtime.dagger.Binds
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.ohmz.reminder.data.repository.ReminderRepository
import com.ohmz.reminder.data.repository.ReminderRepositoryImpl

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
    fun provideReminderRepository(): ReminderRepository = ReminderRepositoryImpl()
}