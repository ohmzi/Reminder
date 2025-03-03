package com.ohmz.reminder.data.repository

import com.ohmz.reminder.domain.model.ReminderList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class ReminderRepositoryImpl : ReminderRepository {
    override fun getLists(): Flow<List<ReminderList>> {
        // Implement actual data source
        return flowOf(listOf(ReminderList("Reminders", 14)))
    }

    override fun saveReminder(title: String): Flow<Unit> {
        // Implement save logic
        return flow { emit(Unit) }
    }

    override fun createList(name: String): Flow<Unit> {
        // Implement create logic
        return flow { emit(Unit) }
    }
}